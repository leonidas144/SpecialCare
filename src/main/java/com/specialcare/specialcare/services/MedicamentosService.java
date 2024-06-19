package com.specialcare.specialcare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specialcare.specialcare.entities.Medicamentos;
import com.specialcare.specialcare.repositories.MedicamentosRepository;

@Service
public class MedicamentosService {
    
    @Autowired
    private MedicamentosRepository repository;
    
    public List<Medicamentos> findAll(){
        return repository.findAll();
    }

    public Medicamentos findById(Integer id){
        Optional<Medicamentos> obj = repository.findById(id);
        return obj.get();
    }

    public Medicamentos insert(Medicamentos obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Medicamentos update(Integer id, Medicamentos obj){
        Medicamentos entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Medicamentos entity, Medicamentos obj) {
        entity.setQuantidade(obj.getQuantidade());
        entity.setData(obj.getData());
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setPacienteMedicamento(obj.getPacienteMedicamento());
    }
}

