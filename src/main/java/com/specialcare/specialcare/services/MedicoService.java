package com.specialcare.specialcare.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specialcare.specialcare.entities.Medico;
import com.specialcare.specialcare.repositories.MedicoRepository;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;
    
    public List<Medico> findAll(){
        return repository.findAll();
    }

    public Medico findById(Integer id){
        Optional<Medico> obj = repository.findById(id);
        return obj.get();
    }

    public Medico insert(Medico obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Medico update(Integer id, Medico obj){
        Medico entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Medico entity, Medico obj) {
        entity.setNome(obj.getNome());
        entity.setEspecialidade(obj.getEspecialidade());
        entity.setTel(obj.getTel());
    }
}