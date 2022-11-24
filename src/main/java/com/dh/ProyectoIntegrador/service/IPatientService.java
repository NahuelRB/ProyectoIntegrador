package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Patient;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface IPatientService{

    @Query("Select p from patient p where a.nombre=?1")
    Optional<Patient> buscarPaciente(String nombre);

    PatientDTO getId(long id);
    Set<PatientDTO> getAll();
    void save(PatientDTO patientDTO);
    void delete(Long id);
    void update(PatientDTO patientDTO);
}
