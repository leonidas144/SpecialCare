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

import com.specialcare.specialcare.entities.Medicamentos;
import com.specialcare.specialcare.services.MedicamentosService;


@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentosController {
    @Autowired
    private MedicamentosService service;

    @GetMapping
    public ResponseEntity <List<Medicamentos>> findAll() {
        List<Medicamentos> list  = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity <Medicamentos> findById(@PathVariable Integer id) {
        Medicamentos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity <Medicamentos> insert(@RequestBody Medicamentos obj) {
        obj = service.insert(obj);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_Medicamentos()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<Medicamentos> update(@PathVariable Integer id, @RequestBody Medicamentos obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
        }
}   
