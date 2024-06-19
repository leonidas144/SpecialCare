package com.specialcare.specialcare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specialcare.specialcare.entities.DiarioPaciente;
import com.specialcare.specialcare.repositories.DiarioPacienteRepository;

@Service
public class DiarioPacienteService {
    
    @Autowired
    private DiarioPacienteRepository repository;
    
    public List<DiarioPaciente> findAll(){
        return repository.findAll();
    }

    public DiarioPaciente findById(Integer id){
        Optional<DiarioPaciente> obj = repository.findById(id);
        return obj.get();
    }

    public DiarioPaciente insert(DiarioPaciente obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public DiarioPaciente update(Integer id, DiarioPaciente obj){
        DiarioPaciente entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(DiarioPaciente entity, DiarioPaciente obj) {
        entity.setData(obj.getData());
        entity.setResumo(obj.getResumo());
        entity.setPacienteDiario(obj.getPacienteDiario());
    }
    
}
