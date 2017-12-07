'''
Created on 13/10/2017

@author: ne.cabrera
'''
import json
import requests
from kafka import KafkaConsumer
from collections import namedtuple

domain = "proyectominas.auth0.com" # Your Auth0 Domain
api_identifier = "grupo9/proyectominas" # API Identifier of your API
client_id = "UzR5wG-A-aVeJQvY5cIeIqFlnfZzpk70" # Client ID of your Non Interactive Client
client_secret = "73UGCbbmh0NV0m_fLDIgSboHQi57nQH3EogZzK2USJu0dfJCuO8YrNpPhzOpAvwf" # Client Secret of your Non Interactive Client
grant_type = "client_credentials" # OAuth 2.0 flow to use

base_url = "https://{domain}".format(domain=domain) + "/oauth/token"


 
consumer = KafkaConsumer('alta.piso1.local1',
                        group_id='temperature',
                         bootstrap_servers=['localhost:8090'])
 
for message in consumer:
    obj = json.loads(message.value,object_hook=lambda d: namedtuple('X', d.keys())(*d.values()))
    payloadSensor ={
        "ubicacion": obj.place,
        "valor": obj.data,
        "unidad": obj.unit,
        "fecha": obj.sensetime
    }
    
    if obj.unit == "C":
        url = 'http://localhost:8084/temperatura'
    if obj.unit == "Lux":
        url = 'http://localhost:8084/iluminacion'
    if obj.unit == "ppm":
        url = 'http://localhost:8084/co'
    if obj.unit == "dB":
        url = 'http://localhost:8084/sonido'
    
    payload = {
        'client_id': client_id,
        'client_secret': client_secret,
        'audience': api_identifier,
        'grant_type': grant_type
    }
    response = requests.post(base_url, data=json.dumps(payload),
                             headers={'Content-type': 'application/json'})
    auth0_response = response.json()
    print("Access Token: " + auth0_response.get('access_token'))
    print("Response Status Code: " + str(response.status_code))
    res = requests.post(url,data=json.dumps(payloadSensor),headers={'Content-type': 'application/json', 'Authorization': 'Bearer ' + auth0_response.get('access_token')})
    print(message.topic)
    print("Res Status Code: " + str(res.status_code))
    
    
