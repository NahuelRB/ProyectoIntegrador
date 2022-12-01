package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    private IDentistService dentistService;
    @Autowired
    public DentistController(IDentistService dentistService) {
        this.dentistService = dentistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> getId(@PathVariable Long id) {
        ResponseEntity<DentistDTO> response = ResponseEntity.notFound().build();
        DentistDTO dentistDTO = dentistService.getId(id);
        if (dentistDTO != null) response = ResponseEntity.ok().body(dentistDTO);
        return response;
    }

    @GetMapping()
    public ResponseEntity<Set<DentistDTO>> getPatients() {
        return new ResponseEntity<>(dentistService.getAll(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DentistDTO> save(@RequestBody DentistDTO dentistDTO) {
        DentistDTO response = dentistService.save(dentistDTO);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity response = null;
        if (id != 0) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        dentistService.delete(id);
        return response;
    }

    @PutMapping
    public void update(@RequestBody DentistDTO dentistDTO){
        dentistService.update(dentistDTO);
    }
}
