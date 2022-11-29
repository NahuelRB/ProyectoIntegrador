package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.service.IPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private IPatientService patientService;
    @Autowired
    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public PatientDTO getId(@PathVariable Long id) {
        return patientService.getId(id);
    }

    //Obtenemos todos los pacientes
    //http://localhost:8080/patient
    @GetMapping()
    public Set<PatientDTO> getPatients() {
        return patientService.getAll();
    }

    @PostMapping()
    public void save(@RequestBody PatientDTO patientDTO) {
        patientService.save(patientDTO);
    }

    @PutMapping()
    public void update(@RequestBody PatientDTO patientDTO){
        patientService.update(patientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity response = null;
        if (id != 0) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        patientService.delete(id);
        return response;
    }

    @GetMapping("/nombre/{nombre}")
    public Patient buscarPorNombre(@PathVariable String nombre){
        System.out.println(nombre);
        return patientService.findPatientByName(nombre);
    }
}