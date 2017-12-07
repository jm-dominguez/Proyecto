/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.auth.AuthorizationFilter.Role;
import co.edu.uniandes.isis2503.nosqljpa.auth.Secured;
import co.edu.uniandes.isis2503.nosqljpa.logic.TemperaturaLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.TemperaturaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.TemperaturaEntity;
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
@Path("/temperatura")
@Secured({Role.admin})
public class TemperaturaResource {
    
    public TemperaturaResource()
    {
        temperaturaLogic = new TemperaturaLogic();
    }
    
     private TemperaturaLogic temperaturaLogic; 
     
     private List<TemperaturaDTO> listEntity2DTO(List<TemperaturaEntity> entityList){
        List<TemperaturaDTO> list = new ArrayList<>();
        for (TemperaturaEntity entity : entityList) {
            list.add(new TemperaturaDTO(entity));
        }
        return list;
    }
     
    @GET
    public List<TemperaturaDTO> getTemperatura() {
        return listEntity2DTO(temperaturaLogic.getTemperaturas());
    }
    
    @GET
    @Path("/pagina")
    public Response getAllTemperatures(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return temperaturaLogic.getAllPage(page,maxRecords);
    }
    
    @POST
    @Secured({Role.admin, Role.service})
    public TemperaturaDTO createTemperatura(TemperaturaDTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new TemperaturaDTO(temperaturaLogic.createTemperaturas(dto.toEntity()));
    }
    
    
    
     
}
