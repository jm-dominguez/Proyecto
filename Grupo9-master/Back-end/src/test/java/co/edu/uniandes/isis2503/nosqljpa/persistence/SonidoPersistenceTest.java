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
//import co.edu.uniandes.isis2503.nosqljpa.model.entity.SonidoEntity;
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
//public class SonidoPersistenceTest extends TestCase{
//    
//   
//    private SonidoPersistence sonidoPersistence;
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
//        sonidoPersistence = new SonidoPersistence(); 
//        SonidoEntity entity = new SonidoEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("casita"); 
//        valor = 23; 
//        
//        entity.setId("734");
//        entity.setFecha(fecha);
//        entity.setUnidad("C");
//        entity.setUbicacion(ubicacion);
//        entity.setValor(valor);
//        
//        sonidoPersistence.add(entity);
//    }
//    
//     protected void setUp1()
//    {
//        sonidoPersistence = new SonidoPersistence(); 
//        SonidoEntity entity = new SonidoEntity(); 
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
//        SonidoEntity entity1 = new SonidoEntity(); 
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
//        sonidoPersistence.add(entity);
//        sonidoPersistence.add(entity1);
//    }
//     
//   
//     public void testCrearYGetSonidoPersistence()
//     {
//         setUp();
//         int numero = sonidoPersistence.all().size();
//         assertEquals("Debe haber una entidad", 1, numero); 
//     }
//     
//     public void testCrearYGetSonidoPersistence2()
//     {
//        setUp();
//        
//        SonidoPersistence sonidoPersistence1 = new SonidoPersistence(); 
//        
//        SonidoEntity entity1 = new SonidoEntity(); 
//        
//        fecha = new Date(); 
//        ubicacion = ("La casa de bibi"); 
//        valor = 23; 
//        
//        entity1.setId("2525");
//        entity1.setFecha(fecha);
//        entity1.setUnidad("dB");
//        entity1.setUbicacion(ubicacion);
//        entity1.setValor(valor);
//        
//       
//        sonidoPersistence1.add(entity1);
//         
//         List<SonidoEntity> lista = new ArrayList();
//         List<SonidoEntity> lista1 = new ArrayList();
//         lista = sonidoPersistence.all();
//         lista1 = sonidoPersistence.all();
//         int numero = lista.size() + lista1.size();
//         assertEquals("Debe haber dos entidades", 2, numero); 
//     }
//}
//    
//    