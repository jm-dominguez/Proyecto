
import React, { Component }
from 'react';
import openSocket from 'socket.io-client';
import { SocketProvider }
from 'socket.io-react';
import io from 'socket.io-client';
import RTChart from 'react-rt-chart';
import C3Chart from 'react-c3js';
import 'c3/c3.css';

const DOMNode = document.getElementById('renderTarget');

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            value: 0,
            time: new Date(),
            unit: ""
        };
        this.handle = this.handle.bind(this);
        this.socket = io.connect("http://localhost:8086/thermalcomfort");
        this.socket.on('mesurements', msg => {
            console.log(msg);
            var mensaje = msg.replace("'", "\"");
            var json = JSON.parse(mensaje);
            console.log(json.unit);
            this.setState({
                value: json.value,
                time: json.time,
                unit: json.unit

            });
        });
    }

    handle(msg) {
        this.setState({
            value: msg.value,
            time: msg.time,
            unit: msg.unit

        });
        console.log(msg.value);
    }

    render() {
        const {isAuthenticated, login} = this.props.auth;
        if (this.state.unit == "C") {
            var dataT = {
                date: new Date(),
                Temperatura: this.state.value
            };
        }
        if (this.state.unit == "Lux") {
            var dataL = {
                date: new Date(),
                Iluminacion: this.state.value
            };
        }
        if (this.state.unit == "ppm") {
            var dataP = {
                date: new Date(),
                Gases: this.state.value
            };
        }
        if (this.state.unit == "dB") {
            var dataD = {
                date: new Date(),
                Ruido: this.state.value
            };
        }


        return (
                <div className="container">
                    
                    {
                        isAuthenticated() && (
                                    
                                    
                                    <div>
                            
  
                                        <h1> Mediciones Actuales de la Mina </h1>
                                        <h4> Las medidas corresponden mediciones en tiempo real de las diferentes variables a controlar de la Mina. </h4>
                                        <p>   </p>
                                        <RTChart rel="stylesheet" href="c3.css" class ="line"
                                
                                            fields={['Temperatura']}
                                            data={dataT} />
                                
                                        <RTChart
                                
                                            fields={['Iluminacion']}
                                            data={dataL} />
                                        <RTChart
                                
                                            fields={['Gases']}
                                            data={dataP} />
                                        <RTChart
                                
                                            fields={['Ruido']}
                                            data={dataD} />
                                    </div>

                                )
                    }
                    {
                        !isAuthenticated() && (
                                    <h4>
                                        You are not logged in! Please{' '}
                                        <a style={{cursor: 'pointer'}}
                                           onClick={login.bind(this)}
                                           >
                                            Log In
                                        </a>
                                        {' '}to continue.
                                    </h4>
                                            )
                    }
                </div>
                            );
                }
    }

    export default Home;
