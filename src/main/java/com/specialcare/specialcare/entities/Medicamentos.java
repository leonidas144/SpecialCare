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
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Medicamentos;
    private int quantidade;
    private Instant data;
    private String nome;
    private String descricao;

    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteMedicamento;

    public Medicamentos() {
    }

    public Medicamentos(Integer id_Medicamentos, int quantidade, Instant data, String nome, String descricao,
            Paciente pacienteMedicamento) {
        this.id_Medicamentos = id_Medicamentos;
        this.quantidade = quantidade;
        this.data = data;
        this.nome = nome;
        this.descricao = descricao;
        this.pacienteMedicamento = pacienteMedicamento;
    }

    public Integer getId_Medicamentos() {
        return id_Medicamentos;
    }


    

    public void setId_Medicamentos(Integer id_Medicamentos) {
        this.id_Medicamentos = id_Medicamentos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Paciente getPacienteMedicamento() {
        return pacienteMedicamento;
    }

    public void setPacienteMedicamento(Paciente pacienteMedicamento) {
        this.pacienteMedicamento = pacienteMedicamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
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
        result = prime * result + ((pacienteMedicamento == null) ? 0 : pacienteMedicamento.hashCode());
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
        Medicamentos other = (Medicamentos) obj;
        if (pacienteMedicamento == null) {
            if (other.pacienteMedicamento != null)
                return false;
        } else if (!pacienteMedicamento.equals(other.pacienteMedicamento))
            return false;
        return true;
    }
    
}
