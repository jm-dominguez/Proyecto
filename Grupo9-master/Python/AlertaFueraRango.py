'''
Created on 14/10/2017

@author: ne.cabrera
'''
from kafka import KafkaConsumer
from collections import namedtuple
import json
import queue
from kafka import KafkaProducer
import time

class ProductorFueraDeRango:
    suma = 0
    dif = 0
    num = 0
    producer = KafkaProducer(value_serializer=lambda m:json.dumps(m).encode('ascii'),bootstrap_servers= ['localhost:8090'])
    
    def __init__(self):
        a = 1

    def enviarAlerta(self, pUbicacion, pValor, pUnidad, pFecha ):
        obj ={
            "ubicacion": pUbicacion,
            "valor": pValor,
            "unidad": pUnidad,
            "timestamp": pFecha,
            "tipo": "fr"
            }
        self.promedio(pFecha)
        a = json.dumps(obj)
        st = str(a)
        b = bytes(st, 'ascii')
        print(b)
        self.producer.send('email', b)
	
    def promedio(self, pFecha):
        actual = int(round(time.time() * 1000))
        self.dif = actual - pFecha
        self.suma += self.dif
        self.num += 1
        if self.num == 5000:
            print("tiempo promedio: ")
            print(self.dif/5000)

class microcontrolador:
    colaTemperatura = queue.Queue(10)
    colaCO = queue.Queue(10)
    colaLuz = queue.Queue(10)
    colaSonido = queue.Queue(10)
    productor = ProductorFueraDeRango()
    fechaPrueba = 0
    def __init__(self, pUbicacion, pValor, pUnidad, pFecha):
        self.ubicacion = pUbicacion
        self.valor = pValor
        self.unidad = pUnidad
        self.fecha = pFecha
    
    def agregarTemperatura(self, pTemp):
        llena = self.colaTemperatura.full()
        if llena:
            self.colaTemperatura.get()
        self.colaTemperatura.put(pTemp)
        limiteInferior = 21.5
        limiteSuperior = 27
        promedio = self.calcularPromedioTemperatura()
        if promedio < limiteInferior or promedio > limiteSuperior:
            #fecha = int(round(time.time() * 1000))
            print(self.fechaPrueba)
            self.productor.enviarAlerta(self.ubicacion, promedio, self.unidad, self.fechaPrueba)
        
    def agregarCO(self, pTemp):
        llena = self.colaCO.full()
        if llena:
            self.colaCO.get()
        self.colaCO.put(pTemp)
        limiteInferior = 80
        limiteSuperior = 85
        promedio = self.calcularPromedioCO()
        if promedio < limiteInferior or promedio > limiteSuperior:
            fecha = int(round(time.time() * 1000))
            self.productor.enviarAlerta(self.ubicacion, promedio, self.unidad, fecha)
        
    def agregarLuz(self, pTemp):
        llena = self.colaLuz.full()
        if llena:
            self.colaLuz.get()
        self.colaLuz.put(pTemp)
        limiteInferior = 100
        limiteSuperior = 500
        promedio = self.calcularPromedioLuz()
        if promedio < limiteInferior or promedio > limiteSuperior:
            fecha = int(round(time.time() * 1000))
            self.productor.enviarAlerta(self.ubicacion, promedio, self.unidad, fecha)
    
    def agregarSonido(self, pTemp):
        llena = self.colaSonido.full()
        if llena:
            self.colaSonido.get()
        self.colaSonido.put(pTemp)
        limiteInferior = 0
        limiteSuperior = 350
        promedio = self.calcularPromedioSonido()
        if promedio < limiteInferior or promedio > limiteSuperior:
            fecha = int(round(time.time() * 1000))
            self.productor.enviarAlerta(self.ubicacion, promedio, self.unidad, fecha)
        
    def calcularPromedioTemperatura(self):
        suma = 0
        num = self.colaTemperatura.qsize()
        aux = queue.Queue()
        for i in range(0,num):
            temp = self.colaTemperatura.get()
            aux.put(temp)
            suma+=temp
        self.colaTemperatura = aux
        print(num)
        return suma/num
    
    def calcularPromedioLuz(self):
        suma = 0
        num = self.colaLuz.qsize()
        aux = queue.Queue()
        for i in range(0, num):
            temp = self.colaLuz.get()
            aux.put(temp)
            suma+=temp
        self.colaLuz = aux
        return suma/num
    
    def calcularPromedioCO(self):
        suma = 0
        num = self.colaCO.qsize()
        aux = queue.Queue()
        for i in range(0, num):
            temp = self.colaCO.get()
            aux.put(temp)
            suma+=temp
        self.colaCO = aux
        return suma/num
    
    def calcularPromedioSonido(self):
        suma = 0
        num = self.colaSonido.qsize()
        aux = queue.Queue()
        for i in range(0, num):
            temp = self.colaSonido.get()
            aux.put(temp)
            suma+=temp
        self.colaSonido = aux
        return suma/num
    

diccionario = {}

 
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
        "unidad": obj.unit,
        "fecha": obj.sensetime
    }
    
    
    micro = microcontrolador(obj.place, obj.data, obj.unit, obj.sensetime)
    micro2 = None
    try:
        micro2 = diccionario[micro.ubicacion]
        
    except:
        diccionario[micro.ubicacion] = micro
        micro2 = diccionario[micro.ubicacion]
        
    if obj.unit == "C":
        micro2.agregarTemperatura(obj.data)
        micro2.fechaPrueba = obj.sensetime
        print('hola')
    if obj.unit == "Lux":
        micro2.agregarLuz(obj.data)
        
    if obj.unit == "ppm":
        micro2.agregarCO(obj.data)
        
    if obj.unit == "dB":
        micro2.agregarSonido(obj.data)
        
    diccionario[micro.ubicacion] = micro2