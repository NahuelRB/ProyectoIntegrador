package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.dto.TurnDTO;

import java.util.Set;

public interface ITurnService {

    TurnDTO getId(long id);
    Set<TurnDTO> getAll();
    void save(TurnDTO turnDTO);
    void delete(Long id);
    void update(TurnDTO turnDTO);

}
