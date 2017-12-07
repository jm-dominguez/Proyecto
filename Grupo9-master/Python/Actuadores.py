'''
Created on 21/10/2017

@author: jc.sanchez16
'''
import json
import requests
import time
from kafka import KafkaConsumer
from kafka import KafkaProducer
from collections import namedtuple
 
consumer = KafkaConsumer('alta.piso1.local1',
                         group_id='my-group',
                         bootstrap_servers=['172.24.42.27:8090'])
act =[]
times=[]
for i in range(len(act)):
    if (times[i]+60000)<=round(time.time()*1000):
        del act[i]
        del times[i]
for message in consumer:
    print ("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                          message.offset, message.key,
                                          message.value))
    obj = json.loads(message.value,object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))
    payload ={
         "ubicacion": obj.ubicacion,
         "valor": obj.valor,
         "unidad": obj.unidad,
         "tipo": obj.tipo,
         "timestamp": obj.timestamp
    }
    b=obj.ubicacion.split(".")  
    try: 
        h= act.index(b[0]+"."+b[1])
        print("ya esta activo el actuador del piso "+ b[0] +" y local "+ b[1])
    except ValueError:
        print("El actuador del piso "+ b[0] +" y local "+ b[1]+" se ha encendido")
        act.append(b[0]+"."+b[1])
        times.insert(len(act)-1,obj.timestamp)
    except IndexError:  
        try:  
            h= act.index(obj.ubicacion)
            print("ya esta activo el actuador de la zona "+ obj.ubicacion)
        except:
            print("El actuador de la zona "+ obj.ubicacion+" se ha encendido")
            act.append(obj.ubicacion)
            times.insert(len(act)-1,obj.timestamp)
            
    print("Aun siguen activos los siguientes(actuador/tiempo restante):")
    for i in range(len(act)):
        print(act[i]+"/"+((times[i]+60000)-round(time.time()*1000)))