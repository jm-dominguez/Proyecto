/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import React from 'react';
import { Button, Form, FormGroup, Label, Input, FormText } from 'reactstrap';
import { Breadcrumb, BreadcrumbItem } from 'reactstrap';

class CRUDAreas extends React.Component {
  render() {
    return (
             <div>
            <Breadcrumb>
        <BreadcrumbItem><a href="por">Funcionalidades</a></BreadcrumbItem>
        <BreadcrumbItem active>CRUDAreas</BreadcrumbItem>
      </Breadcrumb>
        <Form>
        <FormGroup>
          <Label for="nombre">Nombre</Label>
          <Input type="nombre" name="nombre" id="exampleEmail" placeholder="Ingrese el nombre del àrea" />
        </FormGroup>
        <FormGroup>
          <Label for="numeroObreros">Nùmero de obreros</Label>
          <Input type="numeroObreros" name="Nùmero de obreros" id="examplePassword" placeholder="Ingrese el nùmero de obreros" />
        </FormGroup>
       <Button>Submit</Button>
      </Form>
      </div>

        
      
    );
  }
}
export default CRUDAreas;



