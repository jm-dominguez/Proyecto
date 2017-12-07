'''
Created on 22/09/2017

@author: ne.cabrera
'''
import json
import requests
from kafka import KafkaConsumer
from collections import namedtuple
 
consumer = KafkaConsumer('alta.piso1.local1',
                         group_id='my-group',
                         bootstrap_servers=['localhost:8090'])
 
for message in consumer:
    print ("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                          message.offset, message.key,
                                          message.value))
    obj = json.loads(message.value,object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))
    payload ={
        "ubicacion": obj.place,
        "valor": obj.data,
        "unidad": obj.unit
    }
    
    if obj.unit == "C":
        url = 'http://localhost:8084/temperatura'
    if obj.unit == "Lux":
        url = 'http://localhost:8084/luz'
    if obj.unit == "ppm":
        url = 'http://localhost:8084/co'
    if obj.unit == "dB":
        url = 'http://localhost:8084/sonido'

    response = requests.post(url, data=json.dumps(payload),
                             headers={'Content-type': 'application/json'})
    print(message.topic)
    print("Response Status Code: " + str(response.status_code))