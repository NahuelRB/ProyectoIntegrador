package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.dto.TurnDTO;
import com.dh.ProyectoIntegrador.repository.ITurnRepository;
import com.dh.ProyectoIntegrador.service.ITurnService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public TurnDTO getId(@PathVariable Long id){
        return turnService.getId(id);
    }

    @GetMapping()
    public Set<TurnDTO> getAll(){
        return turnService.getAll();
    }

    @PostMapping()
    public void save(@RequestBody TurnDTO turnDTO){
        turnService.save(turnDTO);
    }

}
