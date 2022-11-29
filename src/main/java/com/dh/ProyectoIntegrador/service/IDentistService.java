package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.dto.DentistDTO;

import java.util.Set;

public interface IDentistService {
    DentistDTO getId(long id);
    Set<DentistDTO> getAll();
    void save(DentistDTO dentistDTO);
    void delete(Long id);
    void update(DentistDTO dentistDTO);
}
