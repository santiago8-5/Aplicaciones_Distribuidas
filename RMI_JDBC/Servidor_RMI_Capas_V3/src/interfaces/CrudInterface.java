/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author Santiago
 */
public interface CrudInterface<T> {
    
    public List<T> listar(String texto) throws Exception;
    public boolean eliminar(int id) throws Exception;
    
}
