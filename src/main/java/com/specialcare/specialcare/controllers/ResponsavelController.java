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

import com.specialcare.specialcare.entities.Responsavel;
import com.specialcare.specialcare.services.ResponsavelService;

@RestController
@RequestMapping(value = "/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelService service;

    @GetMapping
    public ResponseEntity <List<Responsavel>> findAll() {
        List<Responsavel> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Responsavel> findById(@PathVariable Integer id) {
        Responsavel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity <Responsavel> insert(@RequestBody Responsavel obj) {
        obj = service.insert(obj);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_Responsavel()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Responsavel> update(@PathVariable Integer id, @RequestBody Responsavel obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
        }
}   
