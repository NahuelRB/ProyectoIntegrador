package com.dh.ProyectoIntegrador.repository;

import com.dh.ProyectoIntegrador.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist,Long> {}
