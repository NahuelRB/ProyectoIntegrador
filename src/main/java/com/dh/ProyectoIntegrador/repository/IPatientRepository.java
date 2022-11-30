package com.dh.ProyectoIntegrador.repository;

import com.dh.ProyectoIntegrador.entity.Dentist;
import com.dh.ProyectoIntegrador.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Long> {

    @Query("SELECT d FROM Patient d where d.name = ?1 and d.lastname= ?2")
    Patient findPatientByNameAndLastname(String name, String lastname);

}
