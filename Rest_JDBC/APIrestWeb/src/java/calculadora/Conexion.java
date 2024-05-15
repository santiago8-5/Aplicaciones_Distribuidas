/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class Conexion {
    
    
    Connection conectar;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/calculadora", "root", "Santiago2001");
            //JOptionPane.showMessageDialog(null, "Conexion Exitosa Con La Base De Datos", "Conexion", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Conexion Fallida" + e, "Conexion", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Connection getConnection() {
        return conectar;
    }

    
}
