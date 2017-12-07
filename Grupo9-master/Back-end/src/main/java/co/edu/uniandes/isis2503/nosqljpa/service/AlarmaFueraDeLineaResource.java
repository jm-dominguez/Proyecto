/*
 * The MIT License
 *
 * Copyright 2017 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.nosqljpa.service;

import co.edu.uniandes.isis2503.nosqljpa.logic.AlarmaFueraDeLineaLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.AlarmaFueraDeLineaDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.AlarmaFueraDeLineaEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ne.cabrera
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/alarmaFL")
public class AlarmaFueraDeLineaResource {
    private AlarmaFueraDeLineaLogic flLogic;
    
    public AlarmaFueraDeLineaResource()
    {
        flLogic = new AlarmaFueraDeLineaLogic();
    }
    
    private List<AlarmaFueraDeLineaDTO> listEntity2DTO(List<AlarmaFueraDeLineaEntity> entityList){
        List<AlarmaFueraDeLineaDTO> list = new ArrayList<>();
        for (AlarmaFueraDeLineaEntity entity : entityList) {
            list.add(new AlarmaFueraDeLineaDTO(entity));
        }
        return list;
    }
    
    @GET
    public List<AlarmaFueraDeLineaDTO> getCO() {
        
        return listEntity2DTO(flLogic.getAlarmasFueraDeLinea());
    }  
    
    @POST
    public AlarmaFueraDeLineaDTO createCO(AlarmaFueraDeLineaDTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new AlarmaFueraDeLineaDTO(flLogic.createAlarmaFueraDeLinea(dto.toEntity()));
    }
}
