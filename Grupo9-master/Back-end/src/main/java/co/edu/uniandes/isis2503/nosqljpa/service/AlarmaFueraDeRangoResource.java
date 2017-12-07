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

import co.edu.uniandes.isis2503.nosqljpa.logic.AlarmaFueraDeRangoLogic;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.AlarmaFueraDeRangoDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.AlarmaFueraDeRangoEntity;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

/**
 *
 * @author ne.cabrera
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/alarmaFR")
public class AlarmaFueraDeRangoResource {
    private AlarmaFueraDeRangoLogic frLogic;
    
    public AlarmaFueraDeRangoResource()
    {
        frLogic = new AlarmaFueraDeRangoLogic();
    }
    
    private List<AlarmaFueraDeRangoDTO> listEntity2DTO(List<AlarmaFueraDeRangoEntity> entityList){
        List<AlarmaFueraDeRangoDTO> list = new ArrayList<>();
        for (AlarmaFueraDeRangoEntity entity : entityList) {
            list.add(new AlarmaFueraDeRangoDTO(entity));
        }
        return list;
    }
    
    @GET
    public List<AlarmaFueraDeRangoDTO> getCO() {
        
        return listEntity2DTO(frLogic.getAlarmasFueraDeRango());
    }  
    
    @POST
    public AlarmaFueraDeRangoDTO createCO(AlarmaFueraDeRangoDTO dto){
        if(dto.getId() == null)
        {
            dto.setId(UUID.randomUUID().toString());
        }
        return new AlarmaFueraDeRangoDTO(frLogic.createAlarmaFueraDeRango(dto.toEntity()));
    }
}
