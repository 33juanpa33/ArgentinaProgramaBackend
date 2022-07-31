package com.portfolio.Alfonso.Controller;

import com.portfolio.Alfonso.model.Experiencia;
import com.portfolio.Alfonso.service.IExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "https://portfolioalfonso.herokuapp.com")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Experiencia> obtenerExperiencia(@PathVariable("id") Long id){
        Experiencia exp = expServ.buscarExperiencia(id);
        return new ResponseEntity <> (exp, HttpStatus.OK);
    }
    
    @PostMapping ("/new")
    public void agregarExperiencia (@RequestBody Experiencia exp) {
        expServ.crearExperiencia(exp);
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Experiencia> verExperiencia () {
        return expServ.verExperiencia();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia (@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }
    
    @PutMapping ("/update")
    public ResponseEntity<Experiencia> editarExperiencia(@RequestBody Experiencia exp) {
        Experiencia updateExperiencia = expServ.editarExperiencia(exp);
        return new ResponseEntity <> (updateExperiencia, HttpStatus.OK);
    }
    
}
