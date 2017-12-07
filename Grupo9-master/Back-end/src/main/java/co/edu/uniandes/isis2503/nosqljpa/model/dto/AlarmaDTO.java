/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.model.dto;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.AlarmaEntity;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;


public class AlarmaDTO {

    public AlarmaDTO() {
    }
    private String id;
    
    private String ubicacion;
    
    private int valor;
    
    private String unidad;
    
    private Date fecha; 
}