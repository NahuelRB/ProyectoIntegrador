package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.entity.Dentist;
import com.dh.ProyectoIntegrador.service.DentistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    static Logger log = Logger.getLogger(DentistController.class);
    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

  @GetMapping("/{id}")
    public Optional<Dentist> getId(@PathVariable int id) {
        log.info("Se solicita el paciente con el ID:" + id);
        return dentistService.getId(id);
    }

    //Obtenemos todos los pacientes
    //http://localhost:8080/patient
    @GetMapping()
    public List<Dentist> getPatients() {
        log.info("Se solicitan todos los pacientes");
        return dentistService.findAll();
    }

    //Guardamos los pacientes y de tener el mismo id lo modificamos
    //http://localhost:8080/patient/save    (en el postman cargamos los datos en el body)
    @PostMapping()
    public Dentist save(@RequestBody Dentist dentist) {
        log.info("Se guardo el paciente");
        return dentistService.save(dentist);
    }

    //Eliminamos un paciente
    //http://localhost:8080/patient?id=xx  ingresamos el id del que queremos eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id) {
        ResponseEntity response = null;
        if (id != 0) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        dentistService.delete(id);
        log.info("Se elimino el paciente con el ID:" + id);
        return response;
    }


}
