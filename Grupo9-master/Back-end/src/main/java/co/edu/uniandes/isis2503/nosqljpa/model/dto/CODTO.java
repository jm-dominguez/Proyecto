/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.model.dto;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.COEntity;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class CODTO {

    public CODTO() {
    }
    private String id;
    
    private String ubicacion;
    
    private int valor;
    
    private String unidad;
    
    private Date fecha; 
    
    public CODTO(COEntity entity){
        if(entity != null)
        {
            this.id = entity.getId();
            this.ubicacion = entity.getUbicacion();
            this.valor = entity.getValor();
            this.fecha = entity.getFecha();
            this.unidad = entity.getUnidad();
        }
        
    }
    
    public COEntity toEntity(){
       COEntity entity = new COEntity();
       entity.setId(this.id);
       entity.setUbicacion(this.ubicacion);
       entity.setValor(this.valor);
       entity.setFecha(this.fecha);
       entity.setUnidad(this.unidad);
       return entity;
    }


    public String getUbicacion() {
        return ubicacion;
    }

    public int getValor() {
        return valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
}