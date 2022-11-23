package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.entity.dto.PatientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface IPatientService{

    @Query("Select p from patient p where a.nombre=?1")
    Optional<Patient> buscarPaciente(String nombre);

    void save(PatientDTO patientDTO);
    PatientDTO getId(Long id);
    void update(PatientDTO patientDTO);
    void delete(Long id);

    Set<PatientDTO> getAll();

}
