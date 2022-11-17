package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.dao.IDaoPrueba;
import com.dh.ProyectoIntegrador.model.Dentist;
import com.dh.ProyectoIntegrador.repository.impl.DentistaRepository;
import org.springframework.stereotype.Service;


public class DentistService {

        private IDaoPrueba<Dentist> dentistIRepository;

        public DentistService(IDaoPrueba<Dentist> dentistIRepository) {
            this.dentistIRepository = dentistIRepository;
        }

        public Dentist buscarId(int id){
           return dentistIRepository.buscar(id);
        }


    }

