package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.repository.impl.PatientRepository;
import com.dh.ProyectoIntegrador.service.PatientService;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    static Logger log = Logger.getLogger(PatientController.class);

    //@Autowired(required = true)
    //private Log log = new Log();
    private PatientService patientService = new PatientService(new PatientRepository());

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getId(@PathVariable int id) {
        log.info("Se solicita el paciente con el ID:" + id);
        return ResponseEntity.ok(patientService.getId(id));
    }

    @GetMapping()
    public List<Patient> getAll() {
        log.info("Se solicitan todos los pacientes");
        return patientService.getAll();
    }

    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient) {
        log.info("Se guardo el paciente");
        return patientService.save(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        log.info("Se elimino el paciente con el ID:" + id);
        ResponseEntity response = null;
        if (patientService.delete(id)) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }
}