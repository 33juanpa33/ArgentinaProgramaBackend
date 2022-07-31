package com.portfolio.Alfonso.service;

import com.portfolio.Alfonso.model.Usuario;
import com.portfolio.Alfonso.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    public UsuarioRepository usuRepo;
    
    @Override
    public List<Usuario> verUsuarios() {
        return usuRepo.findAll();
    }

    @Override
    public void crearUsuario(Usuario usu) {
        usuRepo.save(usu);
    }

    @Override
    public void borrarUsuario(Integer id) {
        usuRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Integer id) {
        return usuRepo.findById(id).orElse(null);
    }

    @Override
    public Usuario editarUsuario(Usuario usu) {
        return usuRepo.save(usu);
    }
    
}
