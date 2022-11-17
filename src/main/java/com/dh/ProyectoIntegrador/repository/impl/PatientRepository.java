package com.dh.ProyectoIntegrador.repository.impl;

import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.repository.IRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PatientRepository implements IRepository<Patient> {

    private Logger log = Logger.getLogger(PatientRepository.class);
    private List<Patient> patients;

    public PatientRepository(List<Patient> patients) {
        this.patients = patients;
    }

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
        return patients;
    }


    @Override
    public Patient save(Patient patient) {
        for(Patient p : patients){
            if (p.getId()==patient.getId()) {
                patients.set(p.getId() - 1, patient);
            }else{
                patient.setId(new Random().nextInt());
                this.patients.add(patient);
            }
        }
        return patient;
    }

    @Override
    public Boolean delete(int id) {
        log.info("Se esta eliminando el paciente con el ID:"+id);
            for(Patient patient : patients){
                if (patient.getId()==id){
                    patients.remove(patient);
                    return true;
                }
            }
            return false;
    }
}
