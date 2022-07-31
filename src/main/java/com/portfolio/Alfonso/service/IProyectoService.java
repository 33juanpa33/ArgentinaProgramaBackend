package com.portfolio.Alfonso.service;

import com.portfolio.Alfonso.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> verProyecto();
    
    public void crearProyecto (Proyecto proy);
    
    public void borrarProyecto (Long id);
    
    public Proyecto buscarProyecto (Long id);
    
    public Proyecto editarProyecto (Proyecto proy);
}
