/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.model.dto;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;




@XmlRootElement
public class SonidoDTO {

    public SonidoDTO (){
    }
    
    private String id;
    
    private String ubicacion;
    
    private int valor;
    
    private String unidad;
    
    private Date fecha; 
    
    public SonidoDTO(SonidoEntity entity){
        if(entity != null)
        {
            this.id = entity.getId();
            this.ubicacion = entity.getUbicacion();
            this.valor = entity.getValor();
            this.fecha = entity.getFecha();
            this.unidad = entity.getUnidad();
        }
        
    }
    public SonidoEntity toEntity(){
       SonidoEntity entity = new SonidoEntity();
       entity.setId(this.getId());
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

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
}