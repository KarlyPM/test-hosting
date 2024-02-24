/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.com.gm.rest.models.service;

import java.util.List;
import mx.com.gm.rest.models.Direccion;

/**
 *
 * @author Gustavo Jimenez
 */
public interface DireccionService {
    public List<Direccion> findAll();
    public void save(Direccion direccion);
    public Direccion uptadeDireccion(Direccion direccion);
    public void deleteDireccion(Integer id);
    public Direccion findById(Integer id);
    
}
