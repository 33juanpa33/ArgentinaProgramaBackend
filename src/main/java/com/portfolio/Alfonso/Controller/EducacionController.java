package com.portfolio.Alfonso.Controller;

import com.portfolio.Alfonso.model.Educacion;
import com.portfolio.Alfonso.service.IEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portfoliojuanpabloalfonso.web.app/")
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Educacion> obtenerEducacion(@PathVariable("id") Long id){
        Educacion edu = eduServ.buscarEducacion(id);
        return new ResponseEntity <> (edu, HttpStatus.OK);
    }
    
    @PostMapping ("/new")
    public void agregarEducacion (@RequestBody Educacion edu) {
        eduServ.crearEducacion(edu);
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Educacion> verEducacion () {
        return eduServ.verEducacion();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarEducacion (@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }
    
    @PutMapping ("/update")
    public ResponseEntity<Educacion> editarEducacion(@RequestBody Educacion edu) {
        Educacion updateEducacion = eduServ.editarEducacion(edu);
        return new ResponseEntity <> (updateEducacion, HttpStatus.OK);
    }
    
}
