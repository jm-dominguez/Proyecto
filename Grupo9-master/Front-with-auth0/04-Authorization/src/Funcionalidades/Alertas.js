/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React from 'react';

import { Table, Button, FormGroup, ControlLabel, FormControl, Glyphicon, Pagination } from 'react-bootstrap';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';
import axios from 'axios';

class Alertas extends React.Component {

    getblah() {
        axios.get('http://localhost:8084/alarmaFL')
                .then(response => this.setState({alarmasFL: response.data.medidas}))
                .catch(error => this.setState({message: error.message}));
    }

    render() {
        return (
                <div>  
           <Breadcrumb>
        <BreadcrumbItem><a href="por">Funcionalidades</a></BreadcrumbItem>
        <BreadcrumbItem active>Alertas</BreadcrumbItem>
      </Breadcrumb>
        <Button color="primary">Reporte</Button>{' '}
        <h4>alarmasFL.ubicacion</h4>
        <h4>alarmasFL.valor</h4>
        <h4>alarmasFL.unidad</h4>
        <h4>alarmasFL.fecha</h4>
             
         
                </div>


                );
    }
}
export default Alertas;



