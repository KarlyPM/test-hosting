/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.rest.models.service;
import java.util.List;
import mx.com.gm.rest.models.HojaVida;
/**
 *
 * @author karla
 */
public interface HojaVidaService {
    
    public List<HojaVida> findAll();
    public void save(HojaVida hojaVida);
    public HojaVida updateHojaVida(HojaVida hojaVida);
    public void deleteHojaVida(Integer id);
    public HojaVida findById(Integer id);
    
}
