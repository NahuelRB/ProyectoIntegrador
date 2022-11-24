package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.repository.IPatientRepository;
import com.dh.ProyectoIntegrador.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service//Se crea el bean de service se pones asi para que quede asentado que es el de negocio
//@AllArgsConstructor//Nos crea todos los constructores posibles con parametros
public class PatientServiceImpl implements IPatientService {

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
        PatientDTO patientDTO =null;
        if(patient.isPresent())
            patientDTO = mapper.convertValue(patient,PatientDTO.class);
        return patientDTO;
    }
    @Override
    public Set<PatientDTO> getAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientDTO = new HashSet<>();
        for(Patient patient: patients){
            patientDTO.add(mapper.convertValue(patient,PatientDTO.class));
        }
        return patientDTO;
    }
    @Override
    public Optional<Patient> buscarPaciente(String nombre) {
        return Optional.empty();
    }

    public void save(PatientDTO patientDTO) {
        Patient patient = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patient);
    }

    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    /*public Patient buscarPorNombre(String nombre){
        return patientRepository.buscarPaciente(nombre).get();
    }*/
/*
    public PatientDTO getId(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO =null;
        if(patient.isPresent())
            patientDTO = mapper.convertValue(patient,PatientDTO.class);
        return patientDTO;
    }

    public Set<PatientDTO> findAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDTO> patientDTO = new HashSet<>();
        for(Patient patient: patients){
            patientDTO.add(mapper.convertValue(patient,PatientDTO.class));
        }
        return patientDTO;
    }



   */
}
