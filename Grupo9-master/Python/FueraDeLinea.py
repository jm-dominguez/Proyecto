'''
Created on 21/10/2017

@author: jc.sanchez16
'''
import json
import requests
from kafka import KafkaConsumer
from kafka import KafkaProducer
from collections import namedtuple
 
consumer = KafkaConsumer('alta.piso1.local1',
                         group_id='my-group',
                         bootstrap_servers=['172.24.42.27:8090'])
producer = KafkaProducer(value_serializer=lambda m: json.dumps(m).encode('ascii'),bootstrap_servers=['localhost:8090'])
ubic =[]
temp=[]
co=[]
luz=[]
ruido=[]
 
for message in consumer:
    print ("%s:%d:%d: key=%s value=%s" % (message.topic, message.partition,
                                          message.offset, message.key,
                                          message.value))
    obj = json.loads(message.value,object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))
    try:
        payload ={
            "ubicacion": obj.place,
            "valor": obj.data,
            "unidad": obj.unit,
            "timestamp": obj.sensetime
        }
    except:
        print("hola")
    try:
        h= ubic.index(obj.place)
    except:    
        h=len(ubic)
        ubic.append(obj.place)
    if obj.unit == "C":
        temp.insert(h,obj.sensetime)
    if obj.unit == "Lux":
        luz.insert(h,obj.sensetime)
    if obj.unit == "ppm":
        co.insert(h,obj.sensetime)
    if obj.unit == "dB":
        ruido.insert(h,obj.sensetime)
    alarmas=[]
    for i in range(len(ubic)):
        try:
            if(temp[i]+300000-obj.sensetime)<0 :
                alarmas.append((str)(ubic[i])+",temperatura,"+(str)(temp[i]))           
            if(co[i]+300000-obj.sensetime)<0 :
                alarmas.append((str)(ubic[i])+",gases,"+(str)(co[i]))
            if(luz[i]+600000-obj.sensetime)<0 :
                alarmas.append((str)(ubic[i])+",iluminacion,"+(str)(luz[i]))
            if(ruido[i]+600000-obj.sensetime)<0 :
                alarmas.append((str)(ubic[i])+",ruido,"+(str)(ruido[i]))
        except IndexError as e:
            print(e)
    print(len(alarmas))
    for ala in alarmas:
        a,b,c=ala.split(",")
        producer.send('email', {'ubicacion': a, 'unidad': b, 'tipo':"fl", 'timestamp':c })
