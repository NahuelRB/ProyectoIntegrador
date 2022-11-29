package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.entity.Dentist;
import com.dh.ProyectoIntegrador.repository.IDentistRepository;
import com.dh.ProyectoIntegrador.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DentistServiceImpl implements IDentistService {
    static Logger log = Logger.getLogger(DentistServiceImpl.class);
    @Autowired
    ObjectMapper mapper;
    private IDentistRepository dentistRepository;

    @Autowired
    public DentistServiceImpl(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public DentistDTO getId(long id) {
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO dentistDTO = null;
        if (dentist.isPresent()) dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        log.info("Se solicita el dentista con el ID:" + id);
        return dentistDTO;
    }

    @Override
    public Set<DentistDTO> getAll() {
        List<Dentist> dentists = dentistRepository.findAll();
        Set<DentistDTO> dentistDTO = new HashSet<>();
        for (Dentist dentist : dentists) {
            dentistDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        log.info("Se solicitan todos los dentistas");
        return dentistDTO;
    }

    @Override
    public void save(DentistDTO dentistDTO) {
        Dentist dentist = mapper.convertValue(dentistDTO, Dentist.class);
        System.out.println(dentist.getId());
        System.out.println(dentist.getName());
        dentistRepository.save(dentist);
        log.info("Se guardo el dentista");
    }

    @Override
    public void delete(Long id) {
        dentistRepository.deleteById(id);
        log.info("Se elimino el dentista con el ID:" + id);
    }

    @Override
    public void update(DentistDTO dentistDTO) {
        save(dentistDTO);
        log.info("Se actualizo el dentista");
    }
}
