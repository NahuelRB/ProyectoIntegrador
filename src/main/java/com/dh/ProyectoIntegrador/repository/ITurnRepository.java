package com.dh.ProyectoIntegrador.repository;

import com.dh.ProyectoIntegrador.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn,Long> {
}
