/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import server.Db;

@WebService
public class CalculadoraWSP3 {

    private int contadorOperaciones;
    double resultado;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/";
    private final String DB = "operacione";
    private final String USER = "root";
    private final String PASSWORD = "Santiago2001";

    Db conexion = new Db();
    

    public CalculadoraWSP3() {
        this.contadorOperaciones = 0;
        
    }

    @WebMethod
    public int sumar(int a, int b) {
        contadorOperaciones++;
        resultado = a + b;
        conexion.registrarOperacion(a, b, "+", resultado);
        return (a + b);
    }

    @WebMethod
    public int restar(int a, int b) {
        contadorOperaciones++;
        resultado = a - b;
        conexion.registrarOperacion(a, b, "-", resultado);
        return (a - b);
    }

    @WebMethod
    public int multiplicar(int a, int b) {
        contadorOperaciones++;
        resultado = a * b;
        conexion.registrarOperacion(a, b, "*", resultado);
        return (a * b);
    }

    @WebMethod
    public int dividir(int a, int b) {
        contadorOperaciones++;
        resultado = a / b;
        conexion.registrarOperacion(a, b, "/", resultado);
        return (a / b);
    }

    @WebMethod
    public int getContadorPeticiones() {
        return (this.contadorOperaciones);
    }
    
}




