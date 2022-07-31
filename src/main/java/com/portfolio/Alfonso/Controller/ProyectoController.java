package com.portfolio.Alfonso.Controller;

import com.portfolio.Alfonso.model.Proyecto;
import com.portfolio.Alfonso.service.IProyectoService;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyServ;
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable("id") Long id){
        Proyecto proy = proyServ.buscarProyecto(id);
        return new ResponseEntity <> (proy, HttpStatus.OK);
    }
    
    @PostMapping ("/new")
    public void agregarProyecto (@RequestBody Proyecto proy) {
        proyServ.crearProyecto(proy);
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Proyecto> verProyecto () {
        return proyServ.verProyecto();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarProyecto (@PathVariable Long id) {
        proyServ.borrarProyecto(id);
    }
    
    @PutMapping ("/update")
    public ResponseEntity<Proyecto> editarProyecto(@RequestBody Proyecto proy) {
        Proyecto updateProyecto = proyServ.editarProyecto(proy);
        return new ResponseEntity <> (updateProyecto, HttpStatus.OK);
    }
    
}
