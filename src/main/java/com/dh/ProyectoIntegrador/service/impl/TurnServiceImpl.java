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
        log.info("Se obtuvieron todas los turnos");
        return turnDTO;
    }

    @Override
    public TurnDTO save(TurnDTO turnDTO) {
        Turn turn = mapper.convertValue(turnDTO, Turn.class);
        Turn saveTurn = turnRepository.save(turn);
        log.info("Se guardo el turno");
        return mapper.convertValue(saveTurn, TurnDTO.class);
    }

    @Override
    public void delete(Long id) {
        turnRepository.deleteById(id);
        log.info("Se eliminó el turno con el ID: " + id);
    }

    @Override
    public void update(TurnDTO turnDTO) {
        save(turnDTO);
        log.info("Se actualizaron los cambios del ID: ");
    }
}
