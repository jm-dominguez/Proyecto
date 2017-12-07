/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.auth.AuthorizationFilter.Role;
import co.edu.uniandes.isis2503.nosqljpa.auth.Secured;
import co.edu.uniandes.isis2503.nosqljpa.logic.SonidoLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.SonidoDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/sonido")
@Secured({Role.admin})
public class SonidoResource {
    
    public SonidoResource()
    {
        this.temperaturaLogic = new SonidoLogic();
    }
    
     private SonidoLogic temperaturaLogic; 
     
     private List<SonidoDTO> listEntity2DTO(List<SonidoEntity> entityList){
        List<SonidoDTO> list = new ArrayList<>();
        for (SonidoEntity entity : entityList) {
            list.add(new SonidoDTO(entity));
        }
        return list;
    }
     
    @GET
    public List<SonidoDTO> getSonido() {
        
        return listEntity2DTO(temperaturaLogic.getSonidos());
    }
    
    @GET
    @Path("/pagina")
    public Response getAllTemperatures(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return temperaturaLogic.getAllPage(page,maxRecords);
    }
    
    @POST
    @Secured({Role.admin, Role.service})
    public SonidoDTO createSonido(SonidoDTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new SonidoDTO(temperaturaLogic.createSonidos(dto.toEntity()));
    }
    
    
    
     
}
