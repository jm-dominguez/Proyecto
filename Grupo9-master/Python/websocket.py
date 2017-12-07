#!/usr/bin/env python
import json
import threading
from threading import Lock
from flask import Flask, render_template
from flask_socketio import SocketIO, emit
from kafka import KafkaConsumer
from collections import namedtuple
 
# Set this variable to "threading", "eventlet" or "gevent" to test the
async_mode = None
 
app = Flask(__name__)
app.config['SECRET_KEY'] = 'secret_thermalcomfort'
socketio = SocketIO(app, async_mode=async_mode)
thread = None
thread_lock = Lock()

 
# Consumidor del topic de Kafka "alta.piso1.local1". Cada valor recibido se envía a través del websocket.
def background_thread_websocket():
    consumer = KafkaConsumer('alta.piso1.local2', group_id='my-group', bootstrap_servers=['172.24.42.27:8090'])
    for message in consumer:
        print("Hola")
        obj = json.loads(message.value,object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))
        
        payload ={
            "time": obj.sensetime,
            "value": obj.data,
			"unit": obj.unit
        }
	
        payload = json.dumps(payload)
		
        socketio.emit('mesurements', payload,
                      namespace='/thermalcomfort')
 
# Rutina que se ejecuta cada vez que se conecta un cliente de websocket e inicia el conmunidor de Kafka
@socketio.on('connect', namespace='/thermalcomfort')
def test_connect():
    global thread
    with thread_lock:
        if thread is None:
            thread = socketio.start_background_task(target=background_thread_websocket)
 
# Iniciar el servicio en el puerto 8086
if __name__ == '__main__':
    socketio.run(app, host='0.0.0.0', port=8086, debug=True)
