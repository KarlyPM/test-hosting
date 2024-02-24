package mx.com.gm.web;

import java.util.List;   
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import mx.com.gm.rest.models.Estudio;
import mx.com.gm.rest.models.service.EstudioService;
import mx.com.gm.rest.models.service.GrupoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/apiempleado")
public class EstudioWebController {

    @Autowired
    private EstudioService estudioService;

    @Autowired
    private GrupoServiceImpl grupoServiceImpl;

    @GetMapping("/agregarEstudio")
    public String agregar(Estudio estudio) {
        return "estudio/formEstudio";
    }

    //@PostMapping( value = "/guardar", consumes = "application/json", produces = "application/json")
    @PostMapping("/guardarEstudio")
    public String guardar(@Valid Estudio estudio, Errors errores) {
        Estudio estudioEnty = null;
        if (errores.hasErrors()) {
            return "/";
        }
        if (estudio.getIdEstudio() == null) {
            estudioService.save(estudio);
        } else {
            estudioEnty = estudioService.uptadeEstudio(estudio);
        }
        return "redirect:/apiempleado/listestudio";
    }

    // @PostMapping( "/editestudio/{id}")
    // @PutMapping(path = "/editestudio/{id}", consumes = {"application/json; charset=utf-8"})
    @GetMapping("/editestudio/{id}")
    public String editar(@PathVariable(value = "id") Integer id,Estudio estudio, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "/";
        }
        estudio = estudioService.findById(id);
        model.addAttribute("estudio", estudio);
        return "estudio/formEstudio";
    }

    @GetMapping("/updestudio")
    public String update(Estudio estudio, Errors errores, Model model) {
        if (errores.hasErrors()) {
            return "/";
        }
        Estudio estudioEnty = estudioService.uptadeEstudio(estudio);
        model.addAttribute("estudio", estudioEnty);
        return "redirect:/apiempleado/listestudio";
    }

    @GetMapping("/listestudio")
    public String card(Model model) {
        List<Estudio> listaEstudi = estudioService.findAll();
        model.addAttribute("estudios", listaEstudi);
        return "estudio/listaEstudios";//"index";
    }

 
    @ModelAttribute
    public void setGenericos(Model model) {
        model.addAttribute("grupos", grupoServiceImpl.findAll());
    }
}