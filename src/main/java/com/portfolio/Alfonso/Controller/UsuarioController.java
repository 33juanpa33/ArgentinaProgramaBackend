package com.portfolio.Alfonso.Controller;

import com.portfolio.Alfonso.model.Usuario;
import com.portfolio.Alfonso.service.IUsuarioService;
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
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuServ;
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable("id") Integer id){
        Usuario usu = usuServ.buscarUsuario(id);
        return new ResponseEntity <> (usu, HttpStatus.OK);
    }
    
    @PostMapping ("/new")
    public void agregarUsuario (@RequestBody Usuario usu) {
        usuServ.crearUsuario(usu);
    }
    
    @GetMapping ("/lista")
    @ResponseBody
    public List<Usuario> verUsuarios () {
        return usuServ.verUsuarios();
    }
    
    @DeleteMapping("/delete/{id}")
    public void borrarUsuario (@PathVariable Integer id) {
        usuServ.borrarUsuario(id);
    }
    
    @PutMapping ("/update")
    public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usu) {
        Usuario updateUsuario = usuServ.editarUsuario(usu);
        return new ResponseEntity <> (updateUsuario, HttpStatus.OK);
    }
}
