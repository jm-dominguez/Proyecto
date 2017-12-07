/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import React from 'react';
import { Button } from 'reactstrap';
import { Link } from 'react-router-dom';
import CRUDMicrocontroladores from './CRUDMicrocontroladores.js';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

class Funcionalidades extends React.Component {
    
    goTo(route) {
    this.props.history.replace(`/${route}`)
  }

  render() {
    return (
            <div>   
            
      <Breadcrumb>
        <BreadcrumbItem active>Funcionalidades</BreadcrumbItem>
      </Breadcrumb>
      
        <Button color="primary" onClick={this.goTo.bind(this, 'Reporte')}>Reporte</Button>{' '}
        <Button color="secondary" onClick={this.goTo.bind(this, 'CRUDMicrocontroladores')}>CRUD microcontrolador</Button>{}
        <Button color="success" onClick={this.goTo.bind(this, 'CRUDNiveles')} >CRUD niveles</Button>{' '}
        <Button color="info" onClick={this.goTo.bind(this, 'CRUDAreas')}>CRUD áreas</Button>{' '}
        <Button color="warning" onClick={this.goTo.bind(this, 'Alertas')} >Consultar alertas</Button>{' '}
        <Button color="danger">Reportar problema</Button>{' '}
        <Button color="link">link</Button>
        
      </div>
    );
  }
}
export default Funcionalidades;