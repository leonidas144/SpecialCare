package com.specialcare.specialcare.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Responsavel;
    private String nome;
    private String telefone;
    private String cep;
    private String rua;
    private int num;
    private String bairro;
    private String cidade;
    
    @JsonIgnore
    @OneToMany(mappedBy="responsavel")
    private List<Paciente> pacientes = new ArrayList<>();

    public Responsavel() {
    }

    public Responsavel(Integer id_Responsavel, String nome, String telefone, String cep, String rua, int num,
            String bairro, String cidade) {
        this.id_Responsavel = id_Responsavel;
        this.nome = nome;
        this.telefone = telefone;
        this.cep = cep;
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
    }



    public Integer getId_Responsavel() {
        return id_Responsavel;
    }

    public void setId_Responsavel(Integer id_Responsavel) {
        this.id_Responsavel = id_Responsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_Responsavel == null) ? 0 : id_Responsavel.hashCode());
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
        Responsavel other = (Responsavel) obj;
        if (id_Responsavel == null) {
            if (other.id_Responsavel != null)
                return false;
        } else if (!id_Responsavel.equals(other.id_Responsavel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Responsavel [id_Responsavel=" + id_Responsavel + ", nome=" + nome + ", telefone=" + telefone + ", cep="
                + cep + ", rua=" + rua + ", num=" + num + ", bairro=" + bairro + ", cidade=" + cidade + ", pacientes="
                + pacientes + "]";
    }

    

    

    
}
