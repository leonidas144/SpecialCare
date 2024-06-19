package com.specialcare.specialcare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specialcare.specialcare.entities.Responsavel;
import com.specialcare.specialcare.repositories.ResponsavelRepository;

@Service
public class ResponsavelService {

    @Autowired
    private ResponsavelRepository repository;
    
    public List<Responsavel> findAll(){
        return repository.findAll();
    }

    public Responsavel findById(Integer id){
        Optional<Responsavel> obj = repository.findById(id);
        return obj.get();
    }

    public Responsavel insert(Responsavel obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Responsavel update(Integer id, Responsavel obj){
        Responsavel entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Responsavel entity, Responsavel obj) {
        entity.setNome(obj.getNome());
        entity.setTelefone(obj.getTelefone());
        entity.setCep(obj.getCep());
        entity.setRua(obj.getRua());
        entity.setNum(obj.getNum());
        entity.setBairro(obj.getBairro());
        entity.setCidade(obj.getCidade());
    }
}
    
