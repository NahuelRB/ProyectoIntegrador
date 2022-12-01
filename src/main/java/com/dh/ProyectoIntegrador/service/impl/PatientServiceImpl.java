package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.controller.PatientController;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.repository.IPatientRepository;
import com.dh.ProyectoIntegrador.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements IPatientService {
    static Logger log = Logger.getLogger(PatientController.class);
    @Autowired
    ObjectMapper mapper;
    private IPatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(IPatientRepository patient) {
        this.patientRepository = patient;
    }

    @Override
    public PatientDTO getId(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if (patient.isPresent())
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        log.info("Se solicita el paciente con el ID: " + id);
        return patientDTO;
    }

    @Override
    public Patient findPatientByNameAndLastname(String name, String lastname){
        return patientRepository.findPatientByNameAndLastname(name,lastname);
    }
    @Override
    public Set<PatientDTO> getAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientDTO = new HashSet<>();
        for (Patient patient : patients) {
            patientDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        log.info("Se solicitan todos los pacientes");
        return patientDTO;
    }

    @Override
    public PatientDTO save(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        Patient savePatient = patientRepository.save(patient);
        log.info("Se guardo el paciente");
       return mapper.convertValue(savePatient, PatientDTO.class);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
        log.info("Se elimino el paciente");
    }

    @Override
    public void update(PatientDTO patientDTO) {
        save(patientDTO);
        log.info("Se modificó el paciente con el ID: ");
    }


}
