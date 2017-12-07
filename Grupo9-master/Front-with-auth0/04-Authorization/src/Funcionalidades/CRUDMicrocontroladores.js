/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React from 'react';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

class CRUDMicrocontroladores extends React.Component {
  render() {
    return (
            <div>
            <Breadcrumb>
        <BreadcrumbItem><a href="por">Funcionalidades</a></BreadcrumbItem>
        <BreadcrumbItem active>CRUDMicrocontroladores</BreadcrumbItem>
      </Breadcrumb>
        <Form>
        <FormGroup>
          <Label for="nombre">Nombre</Label>
          <Input type="nombre" name="nombre" id="exampleEmail" placeholder="Ingrese el nombre del àrea" />
        </FormGroup>
        <FormGroup>
          <Label for="numeroAreas">Tipo</Label>
          <Input type="numeroAreas" name="Nùmero de areas" id="examplePassword" placeholder="Ingrese el tipo del microcontrolador" />
        </FormGroup>
        <FormGroup>
          <Label for="profundidad">Àrea fisica</Label>
          <Input type="profundidad" name="profundidad" id="examplePassword" placeholder="Ingrese la profundidad del nivel" />
        </FormGroup>
        
       <Button>Submit</Button>
       </Form>
       </div>
    );
  }
}
export default CRUDMicrocontroladores;