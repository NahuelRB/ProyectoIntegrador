package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.entity.Dentist;
import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

        private IDentistRepository dentistIRepository;

        @Autowired
    public DentistService(IDentistRepository dentistIRepository) {
        this.dentistIRepository = dentistIRepository;
    }

    public Dentist save(Dentist p) {
        return dentistIRepository.save(p);
    }

    public Optional<Dentist> getId(int id) {
        return dentistIRepository.findById(id);
    }

    public List<Dentist> findAll() {
        return dentistIRepository.findAll();
    }

    public void delete(int id) {
        dentistIRepository.deleteById(id);
    }
    }

