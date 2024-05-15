/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;


import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless
@Path("/operaciones")
public class Calcualdora 
{

    /*
    private void guardarOperacion(String operacion, double operando1, double operando2, double resultado) {
        try {
            Connection conn = conexion.getConnection();
            String sql = "INSERT INTO operaciones (operacion, operando1, operando2, resultado) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, operacion);
            pstmt.setDouble(2, operando1);
            pstmt.setDouble(3, operando2);
            pstmt.setDouble(4, resultado);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */
    
    @GET
    @Path("suma")
    public double suma(@QueryParam("num1") double num1, @QueryParam("num2") double num2) {
        double resultado = num1 + num2;
       // guardarOperacion("suma", num1, num2, resultado);
        return resultado;
    }

    @GET
    @Path("resta")
    public double resta(@QueryParam("num1") double num1, @QueryParam("num2") double num2) {
        double resultado = num1 - num2;
        //guardarOperacion("resta", num1, num2, resultado);
        return resultado;
    }

    @GET
    @Path("multiplicacion")
    public double multiplicacion(@QueryParam("numeroUno") double numeroUno, @QueryParam("numeroDos") double numeroDos) {
        double resultado = numeroUno * numeroDos;
       // guardarOperacion("multiplicacion", numeroUno, numeroDos, resultado);
        return resultado;
    }
    
    

    @GET
    @Path("division")
    public double division(@QueryParam("numero_1") double numero_1, @QueryParam("numero_2") double numero_2) {
        double resultado = numero_1 / numero_2;
        //guardarOperacion("division", numero_1, numero_2, resultado);
        return resultado;
    }

    @GET
    @Path("potencia")
    public double potencia(@QueryParam("num1") double num1, @QueryParam("num2") double num2) {
        double resultado = Math.pow(num1, num2);
        //guardarOperacion("potencia", num1, num2, resultado);
        return resultado;
    }

    @GET
    @Path("modulo")
    public double modulo(@QueryParam("num1") double num1, @QueryParam("num2") double num2) {
        double resultado = num1 % num2;
        //guardarOperacion("modulo", num1, num2, resultado);
        return resultado;
    }

    @GET
    @Path("raizCuadrada")
    public double raizCuadrada(@QueryParam("raiz") double raiz) {
        double resultado = Math.sqrt(raiz);
        //guardarOperacion("raizCuadrada", raiz, 0, resultado);  // El segundo operando es cero
        return resultado;
    }

    @GET
    @Path("factorial")
    public double factorial(@QueryParam("base") double base) {
        double resultado = factorial(base - 1) * base;
        //guardarOperacion("factorial", base, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("logaritmo")
    public double logaritmo(@QueryParam("log") double log) {
        double resultado = Math.log(log);
        //guardarOperacion("logaritmo", log, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("sin")
    public double sen(@QueryParam("seno") double seno) {
        double resultado = Math.sin(seno);
        //guardarOperacion("sin", seno, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("cos")
    public double cos(@QueryParam("cos") double cos) {
        double resultado = Math.cos(cos);
        //guardarOperacion("cos", cos, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("tan")
    public double tan(@QueryParam("tan") double tan) {
        double resultado = Math.tan(tan);
        //guardarOperacion("tan", tan, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("sinh")
    public double senh(@QueryParam("senoh") double senoh) {
        double resultado = Math.sinh(senoh);
        //guardarOperacion("sinh", senoh, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("cosh")
    public double cosh(@QueryParam("cosh") double cosh) {
        double resultado = Math.cosh(cosh);
       // guardarOperacion("cosh", cosh, 0, resultado);  // Solo un operando
        return resultado;
    }

    @GET
    @Path("tanh")
    public double tanh(@QueryParam("tanh") double tanh) {
        double resultado = Math.tanh(tanh);
        //guardarOperacion("tanh", tanh, 0, resultado);  // Solo un operando
        return resultado;
    }
}
