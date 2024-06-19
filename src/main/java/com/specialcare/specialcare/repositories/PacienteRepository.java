package com.specialcare.specialcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.specialcare.specialcare.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {


}
