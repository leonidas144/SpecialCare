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

import com.specialcare.specialcare.entities.DiarioPaciente;
import com.specialcare.specialcare.services.DiarioPacienteService;

@RestController
@RequestMapping(value = "/diariopacientes")
public class DiarioPacienteController {

    @Autowired
    private DiarioPacienteService service;

    @GetMapping
    public ResponseEntity <List<DiarioPaciente>> findAll() {
        List<DiarioPaciente> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <DiarioPaciente> findById(@PathVariable Integer id) {
        DiarioPaciente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity <DiarioPaciente> insert(@RequestBody DiarioPaciente obj) {
        obj = service.insert(obj);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_Diario()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<DiarioPaciente> update(@PathVariable Integer id, @RequestBody DiarioPaciente obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
        }

    
}
