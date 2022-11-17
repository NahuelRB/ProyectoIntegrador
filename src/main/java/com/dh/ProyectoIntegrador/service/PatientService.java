package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.repository.IRepository;
import com.dh.ProyectoIntegrador.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    IRepository<Patient> patientIRepository;

    @Autowired
    public PatientService(IRepository<Patient> patientRepository) {
        this.patientIRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return patientIRepository.save(patient);
    }

    public Patient getId(int id) {
        return patientIRepository.getId(id);
    }

    public List<Patient> getAll() {
        return patientIRepository.getAll();
    }

    public Boolean delete(int id) {
        return patientIRepository.delete(id);
    }
}
