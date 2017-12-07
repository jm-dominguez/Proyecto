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
//import co.edu.uniandes.isis2503.nosqljpa.model.entity.COEntity;
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
//public class COPersistenceTest extends TestCase{
//    
//   
//    private COPersistence coPersistence;
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
//        coPersistence = new COPersistence(); 
//        COEntity entity = new COEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity.setId("72");
//        entity.setFecha(fecha);
//        entity.setUnidad("ppm");
//        entity.setUbicacion(ubicacion);
//        entity.setValor(valor);
//        
//        coPersistence.add(entity);
//    }
//    
//     protected void setUp1()
//    {
//        coPersistence = new COPersistence(); 
//        COEntity entity = new COEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de juan"); 
//        valor = 16; 
//        
//        entity.setId("21");
//        entity.setFecha(fecha);
//        entity.setUnidad("ppm");
//        entity.setUbicacion(ubicacion);
//        entity.setValor(valor);
//        
//        COEntity entity1 = new COEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity1.setId("225");
//        entity1.setFecha(fecha);
//        entity1.setUnidad("ppm");
//        entity1.setUbicacion(ubicacion);
//        entity1.setValor(valor);
//        
//        coPersistence.add(entity);
//        coPersistence.add(entity1);
//    }
//     
//   
//     public void testCrearYGetCOPersistence()
//     {
//         setUp();
//         int numero = coPersistence.all().size();
//         assertEquals("Debe haber una entidad", 1, numero); 
//     }
//     
//     public void testCrearYGetCOPersistence2()
//     {
//        setUp();
//        
//        COPersistence coPersistence1 = new COPersistence(); 
//        
//        COEntity entity1 = new COEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity1.setId("2525");
//        entity1.setFecha(fecha);
//        entity1.setUnidad("ppm");
//        entity1.setUbicacion(ubicacion);
//        entity1.setValor(valor);
//        
//       
//        coPersistence1.add(entity1);
//         
//         List<COEntity> lista = new ArrayList();
//         List<COEntity> lista1 = new ArrayList();
//         lista = coPersistence.all();
//         lista1 = coPersistence.all();
//         int numero = lista.size() + lista1.size();
//         assertEquals("Debe haber dos entidades", 2, numero); 
//     }
//}
//    
//    