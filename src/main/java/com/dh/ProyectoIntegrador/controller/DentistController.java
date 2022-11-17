package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
  /*  private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    //@PostMapping("/saveDentist")
    @PostMapping("/save")
    public Dentist saveDentist(@RequestBody Dentist dentist){
        return dentistService.save(dentist);
    }

    @PutMapping("/update")
    public void updateDentist(Dentist dentist){
        dentistService.update(dentist);
    }

    @DeleteMapping("/delete")
    public void delete(int id){
        dentistService.delete(id);
    }

    @GetMapping("/list")
    public List<Dentist> getAllDentist(){
        return dentistService.getAll();
    }

    @GetMapping("/list/{id}")
    public List<Dentist> getIdDentist(@PathVariable int id){
        return dentistService.getId(id);
    }*/



}
