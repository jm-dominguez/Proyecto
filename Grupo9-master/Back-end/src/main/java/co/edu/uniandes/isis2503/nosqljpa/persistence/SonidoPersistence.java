/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.dto.PaginaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;
import javax.persistence.Query;
import javax.ws.rs.core.Response;



/**
 *
 * @author b.gamba10
 */
public class SonidoPersistence extends Persistencer<SonidoEntity, String>{

    public SonidoPersistence(){
        this.entityClass = SonidoEntity.class;
    }
    
    public Response getAllPage(Integer page, Integer maxRecords) {
        PaginaDTO sonidos = null;
        entityManager = emf.createEntityManager();
        int status = 200;
        try{
            entityManager.getTransaction().begin();
            Query count = entityManager.createQuery("select count(u) from SonidoEntity u");
            Long regCount = 0L;
            regCount = Long.parseLong(count.getSingleResult().toString());
            Query query = entityManager.createQuery("select u from SonidoEntity u");
            if(page != null && maxRecords != null){
                query.setFirstResult((page-1)*maxRecords);
                query.setMaxResults(maxRecords);
            }
            sonidos = new PaginaDTO();
            sonidos.setTotalRecords(regCount);
            sonidos.setMedidas(query.getResultList());
            entityManager.getTransaction().commit();
 
 
        }catch(Exception e){
            if (entityManager.isOpen());
            entityManager.close();
            status = 500;
            e.printStackTrace();
        }finally {
            if (entityManager.isOpen());
            entityManager.close();
        }
        return Response.status(status).header("Access-Control-Allow-Origin", "*").entity(sonidos).build();
    }
}