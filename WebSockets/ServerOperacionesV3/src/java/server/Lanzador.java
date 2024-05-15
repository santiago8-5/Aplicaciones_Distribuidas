/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author Santiago
 */
public class Lanzador {
    public final static String urlCalculadoraWS = "http://192.168.227.67:8080/ServerOperacionesV3/";

    public static void main(String[] args) {
        Endpoint.publish(urlCalculadoraWS, new CalculadoraWSP3());
        System.out.println("Servicio Web en espera en "+urlCalculadoraWS);        
    }
    
}
