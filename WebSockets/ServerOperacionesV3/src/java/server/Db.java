/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Santiago
 */
public class Db {
    
    private String URL, USER, PASSWORD;
    
    
    public void registrarOperacion(double operando1, double operando2, String operador, double resultado) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/operacione", "root", "Santiago2001")) {
            String query = "INSERT INTO operaciones (numero1, numero2, accion, resultado) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDouble(1, operando1);
            statement.setDouble(2, operando2);
            statement.setString(3, operador);
            statement.setDouble(4, resultado);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }

    
}
