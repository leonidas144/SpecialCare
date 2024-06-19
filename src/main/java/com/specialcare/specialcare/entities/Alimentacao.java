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
public class Alimentacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Alimento;
    private String nomeAlimento;
    private Instant data;
    private String descricao;

    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteAlimento;


    public Alimentacao() {
    }

    public Alimentacao(Integer id_Alimento, String nomeAlimento, Instant data, String descricao,
            Paciente pacienteAlimento) {
        this.id_Alimento = id_Alimento;
        this.nomeAlimento = nomeAlimento;
        this.data = data;
        this.descricao = descricao;
        this.pacienteAlimento = pacienteAlimento;
    }

    public Integer getId_Alimento() {
        return id_Alimento;
    }


    public void setId_Alimento(Integer id_Alimento) {
        this.id_Alimento = id_Alimento;
    }


    public String getNomeAlimento() {
        return nomeAlimento;
    }


    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }


    public Instant getData() {
        return data;
    }


    public void setData(Instant data) {
        this.data = data;
    }


    public Paciente getPacienteAlimento() {
        return pacienteAlimento;
    }


    public void setPacienteAlimento(Paciente pacienteAlimento) {
        this.pacienteAlimento = pacienteAlimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Alimento == null) ? 0 : id_Alimento.hashCode());
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
        Alimentacao other = (Alimentacao) obj;
        if (id_Alimento == null) {
            if (other.id_Alimento != null)
                return false;
        } else if (!id_Alimento.equals(other.id_Alimento))
            return false;
        return true;
    }
    
}
