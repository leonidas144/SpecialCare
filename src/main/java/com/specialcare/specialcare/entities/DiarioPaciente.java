package com.specialcare.specialcare.entities;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DiarioPaciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id_Diario;
    private Instant data;
    private String resumo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteDiario;
    
    public DiarioPaciente() {
    }
    
    public DiarioPaciente(Integer id_Diario, String resumo, Instant data, Paciente pacienteDiario) {
        this.id_Diario = id_Diario;
        this.resumo = resumo;
        this.data = data;
        this.pacienteDiario = pacienteDiario;
    }

    public Integer getId_Diario() {
        return id_Diario;
    }

    public void setId_Diario(Integer id_Diario) {
        this.id_Diario = id_Diario;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Paciente getPacienteDiario() {
        return pacienteDiario;
    }

    public void setPacienteDiario(Paciente pacienteDiario) {
        this.pacienteDiario = pacienteDiario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pacienteDiario == null) ? 0 : pacienteDiario.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DiarioPaciente other = (DiarioPaciente) obj;
        if (pacienteDiario == null) {
            if (other.pacienteDiario != null)
                return false;
        } else if (!pacienteDiario.equals(other.pacienteDiario))
            return false;
        return true;
    }
    
}
