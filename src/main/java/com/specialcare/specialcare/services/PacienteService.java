package com.specialcare.specialcare.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specialcare.specialcare.entities.Paciente;
import com.specialcare.specialcare.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;
    
    public List<Paciente> findAll(){
        return repository.findAll();
    }

    public Paciente findById(Integer id){
        Optional<Paciente> obj = repository.findById(id);
        return obj.get();
    }

    public Paciente insert(Paciente obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Paciente update(Integer id, Paciente obj){
        Paciente entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Paciente entity, Paciente obj) {
        entity.setNome(obj.getNome());
        entity.setIdade(obj.getIdade());
        entity.setAcomodacao(obj.getAcomodacao());
        entity.setMedico(obj.getMedico());
        entity.setResponsavel(obj.getResponsavel());
    }
}