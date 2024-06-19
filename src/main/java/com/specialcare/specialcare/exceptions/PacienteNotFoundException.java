package com.specialcare.specialcare.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Indica o status HTTP da resposta
public class PacienteNotFoundException extends RuntimeException {

    private Integer idPaciente;

    public PacienteNotFoundException(Integer idPaciente) {
        super("Paciente não encontrado com ID: " + idPaciente);
        this.idPaciente = idPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }
}