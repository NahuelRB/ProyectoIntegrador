package com.dh.ProyectoIntegrador.repository.impl;

import com.dh.ProyectoIntegrador.model.Patient;
import com.dh.ProyectoIntegrador.repository.IRepository;

import java.text.ParseException;
import java.util.*;

public class PatientRepository implements IRepository<Patient> {

    private List<Patient> patients;

    public PatientRepository(){
        this.patients = loadPatients();
    }

    private List<Patient> loadPatients(){
        List<Patient> patientsList = new ArrayList<>();
        /*SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        Date fecha = formato.parse("11-10-1990");*/
        patientsList.add(new Patient(1,"nahuel","barbosa","11 de septiembre 2070","35403946","aa"));
        patientsList.add(new Patient(2,"asd","ytty","11 de septiembre 2070","35403946","aa"));
        patientsList.add(new Patient(3,"dassds","ghjhg","11 de septiembre 2070","35403946","aa"));
        return patientsList;
    }

    @Override
    public Patient save(Patient patient) {
        if(patient.getId() == 0)
            patient.setId(new Random().nextInt());
        this.patients.add(patient);
        return patient;
    }

    @Override
    public Patient getId(int id) {
        for(Patient patient : patients){
            if(patient.getId()==id){
                return patient;
            }
        }
        return null;
    }

    @Override
    public List<Patient> getAll() {
        return null;
    }

    @Override
    public Patient update(Patient patient) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
            for(Patient patient : patients){
                if (patient.getId()==id){
                    patients.remove(patient);
                    return true;
                }
            }
            return false;
    }
}
