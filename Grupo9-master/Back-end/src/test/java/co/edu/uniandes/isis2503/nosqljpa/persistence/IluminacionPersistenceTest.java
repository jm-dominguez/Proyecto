//package co.edu.uniandes.isis2503.nosqljpa.persistence;
//
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//
//import co.edu.uniandes.isis2503.nosqljpa.model.entity.IluminacionEntity;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import junit.framework.TestCase;
//
//
///**
// *
// * @author n.acevedos
// */
//
//public class IluminacionPersistenceTest extends TestCase{
//    
//   
//    private IluminacionPersistence ilimunacionPersistence;
//    private Date fecha; 
//    private String ubicacion; 
//    private int valor; 
//
//    /**
//     * Configuración inicial de la prueba.
//     *
//     * @generated
//     */
//    protected void setUp()
//    {
//        ilimunacionPersistence = new IluminacionPersistence(); 
//        IluminacionEntity entity = new IluminacionEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity.setId("37");
//        entity.setFecha(null);
//        entity.setUnidad("lux");
//        entity.setUbicacion("home");
//        entity.setValor(valor);
//        
//        ilimunacionPersistence.add(entity);
//    }
//    
//     protected void setUp1()
//    {
//        ilimunacionPersistence = new IluminacionPersistence(); 
//        IluminacionEntity entity = new IluminacionEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de juan"); 
//        valor = 16; 
//        
//        entity.setId("1");
//        entity.setFecha(fecha);
//        entity.setUnidad("C");
//        entity.setUbicacion(ubicacion);
//        entity.setValor(valor);
//        
//        IluminacionEntity entity1 = new IluminacionEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity1.setId("25");
//        entity1.setFecha(fecha);
//        entity1.setUnidad("C");
//        entity1.setUbicacion(ubicacion);
//        entity1.setValor(valor);
//        
//        ilimunacionPersistence.add(entity);
//        ilimunacionPersistence.add(entity1);
//    }
//     
//   
//     public void testCrearYGetIluminacionPersistence()
//     {
//         setUp();
//         int numero = ilimunacionPersistence.all().size();
//         assertEquals("Debe haber una entidad", 1, numero); 
//     }
//     
//     public void testCrearYGetIluminacionPersistence2()
//     {
//        setUp();
//        
//        IluminacionPersistence ilimunacionPersistence1 = new IluminacionPersistence(); 
//        
//        IluminacionEntity entity1 = new IluminacionEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La ca bibi"); 
//        valor = 23; 
//        
//        entity1.setId("352525");
//        entity1.setFecha(null);
//        entity1.setUnidad("lux");
//        entity1.setUbicacion(ubicacion);
//        entity1.setValor(valor);
//        
//       
//        ilimunacionPersistence1.add(entity1);
//         
//         List<IluminacionEntity> lista = new ArrayList();
//         List<IluminacionEntity> lista1 = new ArrayList();
//         lista = ilimunacionPersistence.all();
//         lista1 = ilimunacionPersistence.all();
//         int numero = lista.size() + lista1.size();
//         assertEquals("Debe haber dos entidades", 2, numero); 
//     }
//}
//    
//    