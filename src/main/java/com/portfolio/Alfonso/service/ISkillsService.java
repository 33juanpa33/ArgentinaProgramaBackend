package com.portfolio.Alfonso.service;

import com.portfolio.Alfonso.model.Skills;
import java.util.List;

public interface ISkillsService {
    public List<Skills> verSkills();
    
    public void crearSkills (Skills skill);
    
    public void borrarSkills (Long id);
    
    public Skills buscarSkills (Long id);
    
    public Skills editarSkills (Skills skill);
}
