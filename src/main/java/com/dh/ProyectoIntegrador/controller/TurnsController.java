package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.dto.TurnDTO;
import com.dh.ProyectoIntegrador.entity.Turn;
import com.dh.ProyectoIntegrador.repository.ITurnRepository;
import com.dh.ProyectoIntegrador.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/turns")
public class TurnsController {

    private ITurnService turnService;

    @Autowired
    public TurnsController(ITurnService turnService) {
        this.turnService = turnService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnDTO> getId(@PathVariable Long id){
        ResponseEntity<TurnDTO> response = ResponseEntity.notFound().build();
        TurnDTO turnDTO = turnService.getId(id);
        if (turnDTO != null)
            response = ResponseEntity.ok().body(turnDTO);
        return response;
    }

    @GetMapping()
    public ResponseEntity<Set<TurnDTO>> getAll(){
       return new ResponseEntity<>(turnService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TurnDTO> save(@RequestBody TurnDTO turnDTO){
        TurnDTO response = turnService.save(turnDTO);
        return  ResponseEntity.ok().body(response);
    }

}
