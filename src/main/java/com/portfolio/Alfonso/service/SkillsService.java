package com.portfolio.Alfonso.service;

import com.portfolio.Alfonso.model.Skills;
import com.portfolio.Alfonso.repository.SkillsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsService implements ISkillsService {
    
    @Autowired
    public SkillsRepository skillRepo;
    
    @Override
    public List<Skills> verSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void crearSkills(Skills skill) {
        skillRepo.save(skill);
    }

    @Override
    public void borrarSkills(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Skills buscarSkills(Long id) {
        return skillRepo.findById(id).orElse(null);
    }
    
    @Override
    public Skills editarSkills(Skills skill){
        return skillRepo.save(skill);
    }
}
