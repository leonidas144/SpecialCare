package com.specialcare.specialcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.specialcare.specialcare.entities.Alimentacao;

public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Integer> {
    
}
