package com.dh.ProyectoIntegrador.repository;

import com.dh.ProyectoIntegrador.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
