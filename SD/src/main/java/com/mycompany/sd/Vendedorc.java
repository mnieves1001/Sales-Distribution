/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sd;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Maicol
 */
public class Vendedorc {

    
    int id_recibo;
    String departamento;
    String ciudad;
    String gmail;
    String direccion;
    String cedula;
    String n_cliente;
    String n_negocio;
    
    
    public int getId_recibo() {
        return id_recibo;
    }

    public void setId_recibo(int id_recibo) {
        this.id_recibo = id_recibo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getN_cliente() {
        return n_cliente;
    }

    public void setN_cliente(String n_cliente) {
        this.n_cliente = n_cliente;
    }

    public String getN_negocio() {
        return n_negocio;
    }

    public void setN_negocio(String n_negocio) {
        this.n_negocio = n_negocio;
    }
    
    
    public void insertar(JTextField id,JTextField depa,JTextField ci,JTextField gm,JTextField dir,JTextField ced,JTextField cli,JTextField neg){
        setId_recibo(Integer.parseInt(id.getText()));
        setDepartamento(depa.getText());
        setCiudad(ci.getText());
        setGmail(gm.getText());
        setDireccion(dir.getText());
        setCedula(ced.getText());
        setN_cliente(cli.getText());
        setN_negocio(neg.getText());
        
        
        Conexion c1 = new Conexion();
        
        String consulta = "INSERT INTO recibo (`id_recibo`, `gmail`, `direccion`, `cedula_c`, `nombre_c`, `nombre_n`) VALUES (?,?,?,?,?,?);";
        //INSERT INTO `pi`.`productos` (`id_producto`, `nombre_p`, `precio`, `stock`, `id_marca`, `id_categoria`) VALUES (?,?,?,?,?,?);
        try {
            CallableStatement cs = c1.estableceConexion().prepareCall(consulta);
            cs.setInt(1,getId_recibo());
            cs.setString(2,getGmail());
            cs.setString(3,getDireccion());
            cs.setString(4, getCedula());
            cs.setString(5,getN_cliente());
            cs.setString(6,getN_negocio());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Agregado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.toString());
        }
    }
}
