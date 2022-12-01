package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.controller.AddressController;
import com.dh.ProyectoIntegrador.dto.AddressDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Address;
import com.dh.ProyectoIntegrador.repository.IAddresRepository;
import com.dh.ProyectoIntegrador.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements IAddressService {

    Logger log = Logger.getLogger(AddressServiceImpl.class);
    @Autowired
    ObjectMapper objectMapper;

    private IAddresRepository addresRepository;

    @Autowired
    public AddressServiceImpl(IAddresRepository addresRepository) {
        this.addresRepository = addresRepository;
    }

    @Override
    public AddressDTO getId(Long id) {
        Optional<Address> addressOptional = addresRepository.findById(id);
        Address address = addressOptional.orElse(null);
        log.info("Se obtuvo la dirección con el ID: " + id);
        return objectMapper.convertValue(address, AddressDTO.class);
    }

    @Override
    public Set<AddressDTO> getAll() {
        List<Address> address = addresRepository.findAll();
        Set<AddressDTO> addressDTO = new HashSet<>();
        for(Address add : address){
            addressDTO.add(objectMapper.convertValue(add, AddressDTO.class));
        }
        log.info("Se obtuvieron todas las direcciones");
        return addressDTO;
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        Address address = objectMapper.convertValue(addressDTO, Address.class);
        Address saveAddress = addresRepository.save(address);
        log.info("Se guardo la dirección");
       return objectMapper.convertValue(saveAddress,AddressDTO.class);
    }

    @Override
    public void delete(Long id) {
        addresRepository.deleteById(id);
        log.info("Se eliminó la direccion con el ID: " + id);
    }

    @Override
    public void update(AddressDTO addressDTO) {
        save(addressDTO);
        log.info("Se actualizaron los cambios del ID: " + addressDTO.getId());
    }
}
