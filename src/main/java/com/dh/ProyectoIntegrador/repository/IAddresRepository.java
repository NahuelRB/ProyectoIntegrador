package com.dh.ProyectoIntegrador.repository;

import com.dh.ProyectoIntegrador.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddresRepository extends JpaRepository<Address, Long> {
}
