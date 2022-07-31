package com.portfolio.Alfonso.service;

import com.portfolio.Alfonso.model.Usuario;
import java.util.List;

public interface IUsuarioService {
    public List<Usuario> verUsuarios();
    
    public void crearUsuario (Usuario usu);
    
    public void borrarUsuario (Integer id);
    
    public Usuario buscarUsuario (Integer id);
    
    public Usuario editarUsuario (Usuario usu);
}
