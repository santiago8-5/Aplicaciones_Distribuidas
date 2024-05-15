/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;
import server.CalculadoraWSP;
import server.CalculadoraWSPService;
/**
 *
 * @author Santiago
 */
public class Cliente {
    
    public static void main(String[] args) {
        
        /* obtenemos el puerto para la conexion, conectarnos al objeto calculadoraCliente 
        a las operaciones de nuestros servicios
        */
        CalculadoraWSP calculadoraCliente = new CalculadoraWSPService().getCalculadoraWSPPort();
        System.out.println(calculadoraCliente.sumar(20, 20));
        
    }
    
}
