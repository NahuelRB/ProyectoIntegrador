package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.dto.TurnDTO;
import com.dh.ProyectoIntegrador.entity.Turn;
import com.dh.ProyectoIntegrador.repository.ITurnRepository;
import com.dh.ProyectoIntegrador.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class TurnServiceImpl implements ITurnService {

    Logger log = Logger.getLogger(TurnServiceImpl.class);

    @Autowired
    ObjectMapper mapper;

    private ITurnRepository turnRepository;

    @Autowired
    public TurnServiceImpl(ITurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }


    @Override
    public TurnDTO getId(long id) {
        Optional<Turn> turn = turnRepository.findById(id);
        TurnDTO turnDTO=null;
        if(turn.isPresent())
            turnDTO = mapper.convertValue(turn,TurnDTO.class);
        log.info("Se solicita el turno con el ID:" + id);
        return turnDTO;
    }

    @Override
    public Set<TurnDTO> getAll() {
        List<Turn> turns = turnRepository.findAll();
        Set<TurnDTO> turnDTO = new HashSet<>();
        for(Turn turn : turns)
            turnDTO.add(mapper.convertValue(turn,TurnDTO.class));
        return turnDTO;
    }

    @Override
    public void save(TurnDTO turnDTO) {
        Turn turn = mapper.convertValue(turnDTO, Turn.class);
        turnRepository.save(turn);
        log.info("Se guardo");
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(TurnDTO turnDTO) {

    }
}
