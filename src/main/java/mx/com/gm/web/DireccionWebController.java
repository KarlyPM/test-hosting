/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.com.gm.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import mx.com.gm.rest.models.Direccion;
import mx.com.gm.rest.models.service.DireccionService;
//import mx.com.gm.rest.models.service.PersonaServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Gustavo Jimenez
 */

@Controller
@Slf4j
@RequestMapping("/apiempleado")
public class DireccionWebController {
    
    @Autowired
    private DireccionService direccionService;

    /*@Autowired
    private PersonaServiceImpl personaServiceImpl;*/

    @GetMapping("/agregarDireccion")
    public String agregar(Direccion direccion) {
        return "direccion/formDireccion";
    }

    //@PostMapping( value = "/guardar", consumes = "application/json", produces = "application/json")
    @PostMapping("/guardardireccion")
    public String guardar(@Valid Direccion direccion, Errors errores) {
        Direccion direccionEnty = null;
        if (errores.hasErrors()) {
            return "/";
        }
        if (direccion.getIdDireccion() == null) {
            direccionService.save(direccion);
        } else {
            direccionEnty = direccionService.uptadeDireccion(direccion);
        }
        return "redirect:/";
    }

    // @PostMapping( "/editcomunidad/{id}")
    // @PutMapping(path = "/editcomunidad/{id}", consumes = {"application/json; charset=utf-8"})
    @GetMapping("/editdireccion/{id}")
    public String editar(@PathVariable(value = "id") Integer id,Direccion direccion, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "/";
        }
        direccion = direccionService.findById(id);
        model.addAttribute("comunidad", direccion);
        return "direccion/formDireccion";
    }

    @GetMapping("/upddireccion")
    public String update(Direccion direccion, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "/";
        }
        Direccion direccionEnty = direccionService.uptadeDireccion(direccion);
        model.addAttribute("direccion", direccionEnty);
        return "/";
    }

    @GetMapping("/listdireccion")
    public String card(Model model) {
        List<Direccion> listaDirec = direccionService.findAll();;
        model.addAttribute("direccions", listaDirec);
        return "direccion/listaDireccions";//"index";
    }

    /**
     * Agregamos al Model la lista de Grupos: De esta forma nos evitamos
     * agregarlos en los metodos crear y editar.
     *
     * @return
     */
    
    
    /*@ModelAttribute
    public void setGenericos(Model model) {
        model.addAttribute("grupos", grupoServiceImpl.findAll());
    }*/
    
}
