package com.specialcare.specialcare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specialcare.specialcare.entities.Alimentacao;
import com.specialcare.specialcare.repositories.AlimentacaoRepository;

@Service
public class AlimentacaoService {
    
    @Autowired
    private AlimentacaoRepository repository;
    
    public List<Alimentacao> findAll(){
        return repository.findAll();
    }

    public Alimentacao findById(Integer id){
        Optional<Alimentacao> obj = repository.findById(id);
        return obj.get();
    }

    public Alimentacao insert(Alimentacao obj){
        return repository.save(obj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Alimentacao update(Integer id, Alimentacao obj){
        Alimentacao entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Alimentacao entity, Alimentacao obj) {
        entity.setNomeAlimento(obj.getNomeAlimento());
        entity.setData(obj.getData());
        entity.setDescricao(obj.getDescricao());
        entity.setPacienteAlimento(obj.getPacienteAlimento());
    }

}
