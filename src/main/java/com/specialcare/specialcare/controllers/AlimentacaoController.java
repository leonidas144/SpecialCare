package com.specialcare.specialcare.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.specialcare.specialcare.entities.Alimentacao;
import com.specialcare.specialcare.services.AlimentacaoService;


@RestController
@RequestMapping(value = "/alimentacao")
public class AlimentacaoController {
    
    @Autowired
    private AlimentacaoService service;

    @GetMapping
    public ResponseEntity <List<Alimentacao>> findAll() {
        List<Alimentacao> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Alimentacao> findById(@PathVariable Integer id) {
        Alimentacao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity <Alimentacao> insert(@RequestBody Alimentacao obj) {
        obj = service.insert(obj);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_Alimento()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Alimentacao> update(@PathVariable Integer id, @RequestBody Alimentacao obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
        }
}   