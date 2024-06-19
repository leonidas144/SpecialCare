package com.specialcare.specialcare.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private int idade;
    private int acomodacao;

    @JsonIgnoreProperties("paciente")
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;
    
    

    @OneToMany(mappedBy= "pacienteDiario")
    private List<DiarioPaciente> diarioPacientes = new ArrayList<>();

    @OneToMany(mappedBy= "pacienteMedicamento")
    private List<Medicamentos> medicamentos = new ArrayList<>();

    @OneToMany(mappedBy= "pacienteAlimento")
    private List<Alimentacao> alimentos = new ArrayList<>();
    
    public Paciente() {
    }

    public Paciente(Integer id, String nome, int idade, int acomodacao, Medico medico,
            Responsavel responsavel) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.acomodacao = acomodacao;
        this.medico = medico;
        this.responsavel = responsavel;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(int acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<DiarioPaciente> getDiarioPacientes() {
        return diarioPacientes;
    }

    public void setDiarioPacientes(List<DiarioPaciente> diarioPacientes) {
        this.diarioPacientes = diarioPacientes;
    }    

    public List<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }   

    public List<Alimentacao> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimentacao> alimentos) {
        this.alimentos = alimentos;
    }    


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Paciente other = (Paciente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
