package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Dentist;
import com.dh.ProyectoIntegrador.entity.Patient;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPatientService{

    Patient findPatientByNameAndLastname(String name, String lastname);
    PatientDTO getId(long id);
    Set<PatientDTO> getAll();
    void save(PatientDTO patientDTO);
    void delete(Long id);
    void update(PatientDTO patientDTO);
}
