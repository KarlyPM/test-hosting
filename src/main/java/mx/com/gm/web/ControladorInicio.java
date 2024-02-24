package mx.com.gm.web;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;

import mx.com.gm.rest.models.Comunidad;
import mx.com.gm.rest.models.service.ComunidadService;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    
    

    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){

             
        return "index";
    }
    
//    @GetMapping("/agregar")
//    public String agregar(Comunidad comunidad){
//        return "comunidad";
//    }
//    
//    @PostMapping("/guardar")
//    public String guardar(@Valid Comunidad comunidad, Errors errores){
//        if(errores.hasErrors()){
//            return "modificar";
//        }
//       // comunidadServic. .guardar(comunidad);
//        return "redirect:/";
//    }
//    
//     @GetMapping("/ini")
//    public String card(Model model){
//      List<Comunidad> listaComuni =   comunidadService.listaCom();
//       model.addAttribute("comunidads", listaComuni);
//        return "listaComunidads";//"index";
//    }
    
    
    
    
    
/*
      @GetMapping("/crear_perso")
    public String add(@ModelAttribute Persona persona) {       

        return "persona/formularioPersona";
    }

    @PostMapping("/save_perso")
    public String guardar(@ModelAttribute Persona persona, BindingResult result, Model model, RedirectAttributes attributes) {



        if (result.hasErrors()) {

            System.out.println("Existieron errores");
            return "persona/formularioPersona";
        }
    
        personaService.save(persona);
        attributes.addFlashAttribute("msg", "Los datos fueron guardados!");

        return "redirect:/apisacramento/indexPaginatePersona";
    }

    @GetMapping("/editperso/{id}")
    public String editar(@PathVariable("id") Long idPersona, Model model) {        
        
        Persona persona = personaService.findById(idPersona);
        model.addAttribute("persona", persona);
        return "persona/formularioPersona";
    }
    
    */
    
    /*
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
*/
}
