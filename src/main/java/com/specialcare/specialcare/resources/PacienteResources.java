/*package com.specialcare.specialcare.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.specialcare.specialcare.entities.Paciente;
import com.specialcare.specialcare.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResources {

    @Autowired
    private PacienteService service;
    
    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        List<Paciente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Integer id){
        Paciente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}*/
