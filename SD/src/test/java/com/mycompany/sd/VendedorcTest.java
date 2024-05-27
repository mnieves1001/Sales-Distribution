/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.sd;

import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Maicol
 */
public class VendedorcTest {
    
    public VendedorcTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId_recibo method, of class Vendedorc.
     */
    @Test
    public void testGetId_recibo() {
        System.out.println("getId_recibo");
    int id_recibo = 14;
    Vendedorc instance = new Vendedorc();
    instance.setId_recibo(id_recibo);
    int expResult = id_recibo;
    int result = instance.getId_recibo();
    assertEquals(expResult, result);
    }

    /**
     * Test of setId_recibo method, of class Vendedorc.
     */
    @Test
    public void testSetId_recibo() {
        System.out.println("setId_recibo");
    int id_recibo = 14;
    Vendedorc instance = new Vendedorc();
    instance.setId_recibo(id_recibo);
    int result = instance.getId_recibo();
    assertEquals(id_recibo, result);
    }

    /**
     * Test of getDepartamento method, of class Vendedorc.
     */
    @Test
    public void testGetDepartamento() {
        System.out.println("getDepartamento");
    String departamento = "Cundinamarca";
    Vendedorc instance = new Vendedorc();
    instance.setDepartamento(departamento);
    String expResult = departamento;
    String result = instance.getDepartamento();
    assertEquals(expResult, result);
    }

    /**
     * Test of setDepartamento method, of class Vendedorc.
     */
    @Test
    public void testSetDepartamento() {
        System.out.println("setDepartamento");
    String departamento = "Cundinamarca";
    Vendedorc instance = new Vendedorc();
    instance.setDepartamento(departamento);
    String result = instance.getDepartamento();
    assertEquals(departamento, result);
    }

    /**
     * Test of getCiudad method, of class Vendedorc.
     */
    @Test
    public void testGetCiudad() {
        System.out.println("getCiudad");
    String ciudad = "Fusagasuga";
    Vendedorc instance = new Vendedorc();
    instance.setCiudad(ciudad);
    String expResult = ciudad;
    String result = instance.getCiudad();
    assertEquals(expResult, result);
    }

    /**
     * Test of setCiudad method, of class Vendedorc.
     */
    @Test
    public void testSetCiudad() {
        System.out.println("setCiudad");
    String ciudad = "Fusagasuga";
    Vendedorc instance = new Vendedorc();
    instance.setCiudad(ciudad);
    String result = instance.getCiudad();
    assertEquals(ciudad, result);
    }

    /**
     * Test of getGmail method, of class Vendedorc.
     */
    @Test
    public void testGetGmail() {
        System.out.println("getGmail");
    String gmail = "maicol@gmail.com";
    Vendedorc instance = new Vendedorc();
    instance.setGmail(gmail);
    String expResult = gmail;
    String result = instance.getGmail();
    assertEquals(expResult, result);
    }

    /**
     * Test of setGmail method, of class Vendedorc.
     */
    @Test
    public void testSetGmail() {
        System.out.println("setGmail");
    String gmail = "maicol@gmail.com";
    Vendedorc instance = new Vendedorc();
    instance.setGmail(gmail);
    String result = instance.getGmail();
    assertEquals(gmail, result);
    }

    /**
     * Test of getDireccion method, of class Vendedorc.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
    String direccion = "calle 22 18 34";
    Vendedorc instance = new Vendedorc();
    instance.setDireccion(direccion);
    String expResult = direccion;
    String result = instance.getDireccion();
    assertEquals(expResult, result);
    }

    /**
     * Test of setDireccion method, of class Vendedorc.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
    String direccion = "calle 22 18 34";
    Vendedorc instance = new Vendedorc();
    instance.setDireccion(direccion);
    String result = instance.getDireccion();
    assertEquals(direccion, result);
    }

    /**
     * Test of getCedula method, of class Vendedorc.
     */
    @Test
    public void testGetCedula() {
        System.out.println("getCedula");
    String expResult = "1001";
    Vendedorc instance = new Vendedorc();
    instance.setCedula(expResult);
    String result = instance.getCedula();
    assertEquals(expResult, result);
    }

    /**
     * Test of setCedula method, of class Vendedorc.
     */
    @Test
    public void testSetCedula() {
        System.out.println("setCedula");
    String cedula = "1001";
    Vendedorc instance = new Vendedorc();
    instance.setCedula(cedula);
    String result = instance.getCedula();
    assertEquals(cedula, result);
    }

    /**
     * Test of getN_cliente method, of class Vendedorc.
     */
    @Test
    public void testGetN_cliente() {
        System.out.println("getN_cliente");
    String expResult = "Maicol Stiven Nieves";
    Vendedorc instance = new Vendedorc();
    instance.setN_cliente(expResult);
    String result = instance.getN_cliente();
    assertEquals(expResult, result);
    }

    /**
     * Test of setN_cliente method, of class Vendedorc.
     */
    @Test
    public void testSetN_cliente() {
        System.out.println("setN_cliente");
    String n_cliente = "Maicol Stiven Nieves";
    Vendedorc instance = new Vendedorc();
    instance.setN_cliente(n_cliente);
    String result = instance.getN_cliente();
    assertEquals(n_cliente, result);
    }

    /**
     * Test of getN_negocio method, of class Vendedorc.
     */
    @Test
    public void testGetN_negocio() {
        System.out.println("getN_negocio");
    String expResult = "MSNP";
    Vendedorc instance = new Vendedorc();
    instance.setN_negocio(expResult);
    String result = instance.getN_negocio();
    assertEquals(expResult, result);
    }

    /**
     * Test of setN_negocio method, of class Vendedorc.
     */
    @Test
    public void testSetN_negocio() {
        System.out.println("setN_negocio");
    String n_negocio = "MSNP";
    Vendedorc instance = new Vendedorc();
    instance.setN_negocio(n_negocio);
    String result = instance.getN_negocio();
    assertEquals(n_negocio, result);
    }

    /**
     * Test of insertar method, of class Vendedorc.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        JTextField id = new JTextField("99");
        JTextField depa = new JTextField("Cundinamarca");
        JTextField ci = new JTextField("Fusagasuga");
        JTextField gm = new JTextField("mmaicolnievesjc@gmail.com");
        JTextField dir = new JTextField("calle 21 C#1b 34");
        JTextField ced = new JTextField("100356478");
        JTextField cli = new JTextField("Maicol Nieves");
        JTextField neg = new JTextField("MSNP");
        Vendedorc instance = new Vendedorc();
        instance.insertar(id, depa, ci, gm, dir, ced, cli, neg);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
