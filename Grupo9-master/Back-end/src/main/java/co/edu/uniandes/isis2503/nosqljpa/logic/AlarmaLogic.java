package co.edu.uniandes.isis2503.nosqljpa.logic;




import co.edu.uniandes.isis2503.nosqljpa.model.entity.AlarmaEntity;
import co.edu.uniandes.isis2503.nosqljpa.persistence.AlarmaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

import java.util.List;
import java.util.UUID;



/**
 *
 * @author n.acevedos
 */
public class AlarmaLogic {
    
    private AlarmaPersistence persistence;
    
    public AlarmaLogic()
            {
                this.persistence = new AlarmaPersistence();
            }
    
    
    
    /**
     * Obtiene la lista de los registros de Usuario.
     *
     * @return Colección de objetos de UsuarioEntity.
     * 
     */
   
    public List<AlarmaEntity> getAlarmas() {
        return persistence.all(); 
    }
    
    /**
     * Obtiene los datos de una instancia de Usuario a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de UsuarioEntity con los datos del Usuario consultado.
     * @throws co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException
     *
     */
    public AlarmaEntity getAlarma(String id) {
        AlarmaEntity ue= persistence.find(id);
         if (ue == null)
         {
             System.out.println("No existe un usuario con ese id"); 
         }
         return ue; 
    }
    
    /**
     * Se encarga de crear un Usuario en la base de datos.
     *
     * @param entity Objeto de UsuarioEntity con los datos nuevos
     * @return Objeto de UsuarioEntity con los datos nuevos y su ID.
     * @throws co.edu.uniandes.csw.paseos.exceptions.BusinessLogicException
     * @generated
     */
    public AlarmaEntity createAlarma(AlarmaEntity entity) {
//        if(entity.getId() == null)
//        {
//            entity.setId(UUID.randomUUID().toString());
//        }
        persistence.add(entity);
        return entity;
    }
    
    /**
     * Actualiza la información de una instancia de Usuario.
     *
     * @param entity Instancia de UsuarioEntity con los nuevos datos.
     * @return Instancia de UsuarioEntity con los datos actualizados.
     * 
     */
    // TODO: revisar las validaciones al momento de actualizar
    public AlarmaEntity updateAlarma(AlarmaEntity entity) {
       
        
        return persistence.update(entity);
        
        
    }
    
    /**
     * Elimina una instancia de Usuario de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     *
     */
    // TODO: revisar las validaciones al momento de borrar
    public void deleteAlarma(String id){
       
        persistence.delete(id);
        
    }
    
    
    
}