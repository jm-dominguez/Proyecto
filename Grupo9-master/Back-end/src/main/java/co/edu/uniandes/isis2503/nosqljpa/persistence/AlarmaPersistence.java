/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.AlarmaEntity;



/**
 *
 * @author b.gamba10
 */
public class AlarmaPersistence extends Persistencer<AlarmaEntity, String>{

    public AlarmaPersistence(){
        this.entityClass = AlarmaEntity.class;
    }
}
