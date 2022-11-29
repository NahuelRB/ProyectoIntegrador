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
    public DentistDTO getId(@PathVariable Long id) {
        return dentistService.getId(id);
    }

    @GetMapping()
    public Set<DentistDTO> getPatients() {

        return dentistService.getAll();
    }

    @PostMapping()
    public void save(@RequestBody DentistDTO dentistDTO) {
        dentistService.save(dentistDTO);
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
