package com.portfolio.Alfonso.Controller;

import com.portfolio.Alfonso.model.Skills;
import com.portfolio.Alfonso.service.ISkillsService;
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
@RequestMapping("/skills")
@CrossOrigin(origins = "https://portfoliojuanpabloalfonso.web.app/")
public class SkillsController {
    
    @Autowired
    private ISkillsService skillServ;
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Skills> obtenerSkills(@PathVariable("id") Long id){
        Skills skill = skillServ.buscarSkills(id);
        return new ResponseEntity <> (skill, HttpStatus.OK);
    }
    
    @PostMapping ("/new")
    public void agregarProyecto (@RequestBody Skills skill) {
        skillServ.crearSkills(skill);
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Skills> verSkills () {
        return skillServ.verSkills();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarSkills (@PathVariable Long id) {
        skillServ.borrarSkills(id);
    }
    
    @PutMapping ("/update")
    public ResponseEntity<Skills> editarSkills(@RequestBody Skills skill) {
        Skills updateSkills = skillServ.editarSkills(skill);
        return new ResponseEntity <> (updateSkills, HttpStatus.OK);
    }
    
}
