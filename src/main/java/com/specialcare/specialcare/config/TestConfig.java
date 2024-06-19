package com.specialcare.specialcare.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.specialcare.specialcare.entities.DiarioPaciente;
import com.specialcare.specialcare.entities.Medico;
import com.specialcare.specialcare.entities.Paciente;
import com.specialcare.specialcare.entities.Responsavel;
import com.specialcare.specialcare.repositories.DiarioPacienteRepository;
import com.specialcare.specialcare.repositories.MedicoRepository;
import com.specialcare.specialcare.repositories.PacienteRepository;
import com.specialcare.specialcare.repositories.ResponsavelRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private DiarioPacienteRepository diarioRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    
    @Override
    public void run(String... args) throws Exception {
        Medico m1 = new Medico(null, "Paulo", "Ortopedista", "987654312");
        Medico m2 = new Medico(null, "Ana", "Neurologista", "987654312");
        
        Responsavel r1 = new Responsavel(null, "Claudia", "99832324", "18053030", "Maria Germani", 100, "Julio", "Sorocaba");
        Responsavel r2 = new Responsavel(null, "Roberta", "99832324", "18053030", "Maria Germani", 100, "Julio", "Sorocaba");


        Paciente p1 = new Paciente(null, "jao", 70, 120, m1, r1);
        Paciente p2 = new Paciente(null, "jose", 50, 130, m2, r2);
        Paciente p3 = new Paciente(null, "craudio", 60, 110, m1, null);
        
        medicoRepository.saveAll(Arrays.asList(m1, m2));
        responsavelRepository.saveAll(Arrays.asList(r1, r2));
        pacienteRepository.saveAll(Arrays.asList(p1, p2, p3));
        
        

        DiarioPaciente diario1 = new DiarioPaciente(null,"Seu Jão tomou a medicação sem choro", Instant.parse("2024-02-20T10:01:02Z"),p1);
        DiarioPaciente diario2 = new DiarioPaciente(null,"Seu Jose se alimentou bem", Instant.parse("2024-02-20T10:01:02Z"), p2);
        DiarioPaciente diario3 = new DiarioPaciente(null,"Seu Craudio chorou de dor a noite toda, é manha", Instant.parse("2024-02-20T23:01:02Z"), p3);
        DiarioPaciente diario4 = new DiarioPaciente(null,"Seu Jão não tomou bezeta", Instant.parse("2024-02-22T10:01:02Z"),p1);

        diarioRepository.saveAll(Arrays.asList(diario1, diario2, diario3, diario4));



       /*  p1.setDiarioPaciente(diario1);
        p2.setDiarioPaciente(diario2);
        p3.setDiarioPaciente(diario3);
        p1.setDiarioPaciente(diario4);

        pacienteRepository.save(p1);
        pacienteRepository.save(p2);
        pacienteRepository.save(p3);
        pacienteRepository.save(p1);*/
    }
    
}
