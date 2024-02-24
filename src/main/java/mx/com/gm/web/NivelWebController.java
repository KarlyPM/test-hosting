/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import mx.com.gm.rest.models.Nivel;
import mx.com.gm.rest.models.service.EstudioServiceImpl;
import mx.com.gm.rest.models.service.NivelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author karla
 */
@Controller
@Slf4j
@RequestMapping("/apiempleado")
public class NivelWebController {
    
    
    @Autowired
    private NivelService nivelService;

    @Autowired
    private EstudioServiceImpl estudioServiceImpl;

    @GetMapping("/agregarnivel")
    public String agregar(Nivel nivel) {
        return "nivel/formNivel";
    }

    @PostMapping("/guardarnivel")
    public String guardar(@Valid Nivel nivel, Errors errores) {
        Nivel nivelEnty = null;
        if (errores.hasErrors()) {
            return "/";
        }
        if (nivel.getIdNivel()== null) {
            nivelService.save(nivel);
        } else {
            nivelEnty = nivelService.updateNivel(nivel);
        }
        return "redirect:/apiempleado/niveles";
    }
    
    @GetMapping("/editarnivel/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Nivel nivel, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "/";
        }
        nivel = nivelService.findById(id);
        model.addAttribute("nivel", nivel);
        return "nivel/formNivel";
    }
    

    @GetMapping("/updatenivel")
    public String update(Nivel nivel, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "/";
        }
        Nivel nievelEnty = nivelService.updateNivel(nivel);
        model.addAttribute("nivel", nievelEnty);
        
        return "redirect:/apiempleado/niveles";
    }
    
   
    @GetMapping("/niveles")
    public String card(Model model) {
        List<Nivel> niveles = nivelService.findAll();
        model.addAttribute("niveles", niveles);
        return "nivel/listaNiveles";//"index";
    }
    
    @ModelAttribute
    public void setGenericos(Model model) {
        model.addAttribute("estudios", estudioServiceImpl.findAll());
    }
 
}