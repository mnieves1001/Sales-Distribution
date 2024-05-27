/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sd;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Maicol
 */
public class ProductosC {
    int id;
    String nombreP;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }
    
    
    public void insertar(JTextField pid_p,JTextField pnom_p){
        setId(Integer.parseInt(pid_p.getText()));
        setNombreP(pnom_p.getText());
        
        
        
        Conexion c1 = new Conexion();
        
        String consulta = "INSERT INTO productos (`id_producto`, `nombre_producto`) VALUES (?,?);";
        //INSERT INTO `pi`.`productos` (`id_producto`, `nombre_p`, `precio`, `stock`, `id_marca`, `id_categoria`) VALUES (?,?,?,?,?,?);
        try {
            CallableStatement cs = c1.estableceConexion().prepareCall(consulta);
            cs.setInt(1,getId());
            cs.setString(2,getNombreP());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Agregado");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.toString());
        }
    }
    
    
    
    public void Mostrar(JTable ptablapro){
        Conexion c1 = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(modelo);
        ptablapro.setRowSorter(OrdenarTabla);
        
        String sql = "";
        
        modelo.addColumn("Id Producto");
        modelo.addColumn("Nombre ");
        
        
        ptablapro.setModel(modelo);
        
        sql = "SELECT * FROM productos;";
        
        String[] datos = new String[2];
        Statement st;
        
        try {
            st = c1.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                
                
                modelo.addRow(datos);
            }
            ptablapro.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.toString());
        }
    }
    
    
    
    public void Seleccionar(JTable ptablapro,JTextField pid_p,JTextField pnom_p){
        try {
            int fila = ptablapro.getSelectedRow();
            
            if(fila>=0){
                pid_p.setText((ptablapro.getValueAt(fila, 0).toString()));
                pnom_p.setText((ptablapro.getValueAt(fila, 1).toString()));
                
            }else{
                JOptionPane.showMessageDialog(null, "Fila NO selecionada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.toString());
        }
    }
    
    
    
    public void Actualizar(JTextField pid_p,JTextField pnom_p){
        setId(Integer.parseInt(pid_p.getText()));
        setNombreP(pnom_p.getText());
        
        
        Conexion c1 = new Conexion();
        String consulta = "UPDATE productos SET nombre_producto WHERE id_producto = ?;";
        
        try {
            CallableStatement sc = c1.estableceConexion().prepareCall(consulta);
            
            sc.setString(1,getNombreP());
            
            
            sc.execute();
            
            JOptionPane.showMessageDialog(null, "Actualizado");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.toString());
        }
    }
    
    
    
    public void Eliminar(JTextField pid_p){
        setId(Integer.parseInt(pid_p.getText()));
        
        Conexion c1 = new Conexion();
        String consulta = "DELETE FROM productos WHERE (`id_producto` = ?);";
        
        try {
            CallableStatement sc = c1.estableceConexion().prepareCall(consulta);
            sc.setInt(1, getId());
            sc.execute();
            JOptionPane.showMessageDialog(null, "Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR"+e.toString());
        }
    }
    
    
}
