package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.repository.impl.PatientRepository;
import com.dh.ProyectoIntegrador.repository.impl.PatientRepositoryH2;
import com.dh.ProyectoIntegrador.model.Patient;
import com.dh.ProyectoIntegrador.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;// = new PatientService(new PatientRepository());

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getId(@PathVariable int id) {
        return ResponseEntity.ok(patientService.getId(id));
    }

    @PostMapping("/save")
    public Patient save(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping()
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        ResponseEntity response = null;
        if (patientService.delete(id))
            response = ResponseEntity.status(HttpStatus.OK).build();
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @PostMapping("/update")
    public Patient update(@RequestBody Patient patient) {
        return patientService.update(patient);
    }

}