package com.dh.ProyectoIntegrador.controller;

import com.dh.ProyectoIntegrador.dto.AddressDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {

    private IAddressService addressService;

    @Autowired
    public AddressController(IAddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Long id) {
        ResponseEntity<AddressDTO> response = ResponseEntity.notFound().build();
        if (id > 0)
            return new ResponseEntity<>(addressService.getId(id),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping()
    public ResponseEntity<Set<AddressDTO>> getPatients() {
        return new ResponseEntity<>(addressService.getAll(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO) {
        AddressDTO response = addressService.save(addressDTO);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping()
    public void update(@RequestBody AddressDTO addressDTO){
        addressService.update(addressDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ResponseEntity response = null;
        if (id != 0) response = ResponseEntity.status(HttpStatus.OK).build();
        else response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        addressService.delete(id);
        return response;
    }
}
