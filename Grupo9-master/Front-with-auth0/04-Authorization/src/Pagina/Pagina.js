import React, { Component } from 'react';
import { Table, Button, FormGroup, ControlLabel, FormControl, Glyphicon, Pagination } from 'react-bootstrap';
import { API_URL } from './../constants';
import Temperatura from './temperatura';
import axios from 'axios';

class Pagina extends Component {
  componentWillMount() {
    this.setState({ 
      temperaturas: [],
      message: '',
      ubicacion: '',
      valor: '',
      unidad:'',
      fecha:'',
      totalRecords: '',
      currentPage:1
    });
    this.handleSelect = this.handleSelect.bind(this);
  }
  componentDidMount() {
    this.getTemperatura();
  }
  handleNameChange(event) {
    this.setState({ name: event.target.value });
  }
  handleCodeChange(event) {
    this.setState({ code: event.target.value });
  }
  addTemperatura(event) {
    event.preventDefault();
    const { getIdToken } = this.props.auth;
    const headers = { Authorization: `Bearer ${getIdToken()}`};
    const temperatura = { name: this.state.name, code: this.state.code };
    axios.post(`${API_URL}/temperatura`, temperatura, { credentials: true, headers: headers })
    .then(response => this.getFloors())
    .catch(error => this.setState({ message: error.message }));
  }
  handleSelect(eventKey){
    console.log(this);
        this.state.currentPage = eventKey;
    this.getTemperatura();
  }
  getTemperatura() {
    
    var paginaActual = this.state.currentPage;
    var url = '/temperatura/pagina?page=' + paginaActual + '&maxRecords=10';
    const { getIdToken } = this.props.auth;
    const headers = { Authorization: `Bearer ${getIdToken()}`};
    axios.get(`${API_URL}` + url, { credentials: true, headers: headers })
    .then(response => this.setState({ temperaturas: response.data.medidas, totalRecords: response.data.totalRecords }))
    .catch(error => this.setState({ message: error.message }));
     
  }
  render() {
    const { isAuthenticated } = this.props.auth;
    return (
      <div className="container">
      <h1>Temperaturas</h1>
      
      
      <Table striped bordered condensed hover className="center">
        <thead>
          <tr>
            <th>#</th>
            <th>ID</th>
            <th>Ubicacion</th>
            <th>Valor</th>
            <th>Unidad</th>
            <th>Fecha</th>
          </tr>
        </thead>
        <tbody>
          {this.state.temperaturas.map((temperatura, index) => {
          return (
            <Temperatura
              key={index}
              number={index + 1}
              id={temperatura.id}
              ubicacion={temperatura.ubicacion}
              valor={temperatura.valor}
              unidad={temperatura.unidad}
              fecha={temperatura.fecha}
              auth={this.props.auth}
              getFloors={() => this.getFloors()}
            />
          );
        })}
        </tbody>
      </Table>
       
       <div>
        <Pagination
        prev
        next
        first
        last
        ellipsis
        boundaryLinks
        items={Math.ceil(this.state.totalRecords / 10)}
        maxButtons={5}
        activePage={this.state.currentPage}
        onSelect={this.handleSelect}
      />
      
        <br />
      </div>
      
      <h2>{this.state.message}</h2>
      </div>
      );
  }
}

export default Pagina;
