package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.repository.IRepository;
import com.dh.ProyectoIntegrador.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public class PatientService {

    private IRepository<Patient> patientIRepository;

    public PatientService(IRepository<Patient> patientRepository) {
        this.patientIRepository = patientRepository;
    }

    public Patient save(Patient patient){
        return patientIRepository.save(patient);
    }

    public Patient getId(int id){
        return patientIRepository.getId(id);
    }

    public List<Patient> getAll(){
        return patientIRepository.getAll();
    }

    public Boolean delete(int id){
        return patientIRepository.delete(id);
    }

    public Patient update(Patient patient){
        return patientIRepository.update(patient);
    }


}
