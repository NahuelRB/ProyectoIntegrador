package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.repository.impl.PatientRepository;
import com.dh.ProyectoIntegrador.service.PatientService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//Lo ponemos al que se comunica con la vista o sea el front
@RequestMapping("/patient")//Aca designo como va a ser la url
public class PatientController {
    static Logger log = Logger.getLogger(PatientController.class);

    //@Autowired(required = true)
    //private Log log = new Log();

    private PatientService patientService = new PatientService(new PatientRepository());

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getId(@PathVariable int id) {
        log.info("Se solicita el paciente con el ID:" + id);
        return ResponseEntity.ok(patientService.getId(id));
    }

    //Obtenemos todos los pacientes
    //http://localhost:8080/patient
    @GetMapping()
    public List<Patient> getAll() {
        log.info("Se solicitan todos los pacientes");
        return patientService.getAll();
    }

    //Guardamos los pacientes y de tener el mismo id lo modificamos
    //http://localhost:8080/patient/save    (en el postman cargamos los datos en el body)
    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient) {
        log.info("Se guardo el paciente");
        return patientService.save(patient);
    }

    //Eliminamos un paciente
    //http://localhost:8080/patient?id=xx  ingresamos el id del que queremos eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        log.info("Se elimino el paciente con el ID:" + id);
        ResponseEntity response = null;
        if (patientService.delete(id)) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }
}