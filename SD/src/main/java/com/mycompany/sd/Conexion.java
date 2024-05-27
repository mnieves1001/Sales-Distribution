/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sd;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Maicol
 */
public class Conexion {
    Connection conectar = null;
    String usuario="root";
    String contraseña="123456789";
    String bd="sd";
    String ip="localhost";
    String puerto="3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contraseña);
            //JOptionPane.showMessageDialog(null, "Conectados pa");
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente a la base de datos");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la base de datos"+e.toString());
            
        }
        return conectar;
    }
}
