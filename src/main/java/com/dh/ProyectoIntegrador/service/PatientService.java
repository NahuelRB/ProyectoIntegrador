package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.repository.IRepository;
import com.dh.ProyectoIntegrador.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//Se crea el bean de service se pones asi para que quede asentado que es el de negocio
@AllArgsConstructor//Nos crea todos los constructores posibles con parametros
public class PatientService {

    @Autowired//lo utilizamos para la inyección de dependencia
    IRepository<Patient> patientIRepository;


    /*public PatientService(IRepository<Patient> patientRepository) {
        this.patientIRepository = patientRepository;
    }*/

    //Aca estan los metodos que utilizamos con los pacientes para alta, modificacion y eliminacion
    //Desde aca se dirige hacia donde se almacenara

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
