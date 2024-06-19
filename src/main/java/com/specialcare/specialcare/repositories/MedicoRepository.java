package com.specialcare.specialcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.specialcare.specialcare.entities.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
}
