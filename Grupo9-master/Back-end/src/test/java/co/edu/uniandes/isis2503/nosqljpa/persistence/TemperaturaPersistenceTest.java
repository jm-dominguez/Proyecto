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
//import co.edu.uniandes.isis2503.nosqljpa.model.entity.TemperaturaEntity;
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
//public class TemperaturaPersistenceTest extends TestCase{
//    
//   
//    private TemperaturaPersistence temperaturaPersistence;
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
//        temperaturaPersistence = new TemperaturaPersistence(); 
//        TemperaturaEntity entity = new TemperaturaEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity.setId("7");
//        entity.setFecha(fecha);
//        entity.setUnidad("C");
//        entity.setUbicacion(ubicacion);
//        entity.setValor(valor);
//        
//        temperaturaPersistence.add(entity);
//    }
//    
//     protected void setUp1()
//    {
//        temperaturaPersistence = new TemperaturaPersistence(); 
//        TemperaturaEntity entity = new TemperaturaEntity(); 
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
//        TemperaturaEntity entity1 = new TemperaturaEntity(); 
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
//        temperaturaPersistence.add(entity);
//        temperaturaPersistence.add(entity1);
//    }
//     
//   
//     public void testCrearYGetTemperaturaPersistence()
//     {
//         setUp();
//         int numero = temperaturaPersistence.all().size();
//         assertEquals("Debe haber una entidad", 1, numero); 
//     }
//     
//     public void testCrearYGetTemperaturaPersistence2()
//     {
//        setUp();
//        
//        TemperaturaPersistence temperaturaPersistence1 = new TemperaturaPersistence(); 
//        
//        TemperaturaEntity entity1 = new TemperaturaEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity1.setId("252525");
//        entity1.setFecha(fecha);
//        entity1.setUnidad("C");
//        entity1.setUbicacion(ubicacion);
//        entity1.setValor(valor);
//        
//       
//        temperaturaPersistence1.add(entity1);
//         
//         List<TemperaturaEntity> lista = new ArrayList();
//         List<TemperaturaEntity> lista1 = new ArrayList();
//         lista = temperaturaPersistence.all();
//         lista1 = temperaturaPersistence.all();
//         int numero = lista.size() + lista1.size();
//         assertEquals("Debe haber dos entidades", 2, numero); 
//     }
//}
//    
//    