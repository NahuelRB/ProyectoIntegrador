package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.dto.AddressDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Patient;
import com.dh.ProyectoIntegrador.service.IPatientService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/patient")
public class PatientController {

    Logger log = Logger.getLogger(PatientController.class);

    private IPatientService patientService;

    @Autowired
    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getId(@PathVariable Long id) {
        ResponseEntity<PatientDTO> response = ResponseEntity.notFound().build();
        PatientDTO patientDTO = patientService.getId(id);
        if (patientDTO != null) {
            response = ResponseEntity.ok().body(patientDTO);
        } else {
            log.error("No se encontro el paciente");
        }
        return response;
    }

    @GetMapping()
    public ResponseEntity<Set<PatientDTO>> getPatients() {
        ResponseEntity<Set<PatientDTO>> response = ResponseEntity.badRequest().build();
        Set<PatientDTO> patientDTO = patientService.getAll();
        if (patientDTO != null) response = ResponseEntity.ok().body(patientDTO);
        else log.error("No se encontraron pacientes");

        return response;
    }

    @PostMapping()
    public ResponseEntity<PatientDTO> save(@RequestBody PatientDTO patientDTO) {
        PatientDTO response = patientService.save(patientDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping()
    public void update(@RequestBody PatientDTO patientDTO) {
        patientService.update(patientDTO);
        log.error("Se guardaron los cambios");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity response = null;
        if (id != 0) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        patientService.delete(id);
        return response;
    }

    @GetMapping("/byName/{name}/{lastname}")
    public Patient buscarPorNombre(@PathVariable String name, @PathVariable String lastname) {
        return patientService.findPatientByNameAndLastname(name, lastname);
    }
}