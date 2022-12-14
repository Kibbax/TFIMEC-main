package com.portfolio.mec.Controller;

import com.portfolio.mec.Entity.Persona;
import com.portfolio.mec.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    //Traer una lista de personas
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    //Gurardar un objeto de tipo persona
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    //Eliminar un objeto tipo Persona
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }
    
    //Editar objetos de tipo persona
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("img") String nuevoImg){
        Persona persona = ipersonaService.findPersona(id);
    
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
    
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    //Trae mi perfil
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
    
    
}
