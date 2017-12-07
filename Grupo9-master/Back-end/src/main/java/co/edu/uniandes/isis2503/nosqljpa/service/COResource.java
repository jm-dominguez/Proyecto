/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;
import co.edu.uniandes.isis2503.nosqljpa.auth.AuthorizationFilter.Role;
import co.edu.uniandes.isis2503.nosqljpa.auth.Secured;
import co.edu.uniandes.isis2503.nosqljpa.logic.COLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.CODTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.COEntity;
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
@Path("/co")
@Secured({Role.admin})
public class COResource {
    
    private COLogic coLogic;  
    
    public COResource()
    {
        this.coLogic = new COLogic();  
    }
     
     private List<CODTO> listEntity2DTO(List<COEntity> entityList){
        List<CODTO> list = new ArrayList<>();
        for (COEntity entity : entityList) {
            list.add(new CODTO(entity));
        }
        return list;
    }
     
    @GET
    public List<CODTO> getCO() {
        
        return listEntity2DTO(coLogic.getCOs());
    }
    
    @GET
    @Path("/pagina")
    public Response getAllTemperatures(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords) {
        return coLogic.getAllPage(page,maxRecords);
    }
    
    @POST
    @Secured({Role.admin, Role.service})
    public CODTO createCO(CODTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new CODTO(coLogic.createCO(dto.toEntity()));
    }
    
    
    
     
}
