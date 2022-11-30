package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.dto.AddressDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.entity.Address;
import com.dh.ProyectoIntegrador.repository.IAddresRepository;
import com.dh.ProyectoIntegrador.service.IAddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    ObjectMapper objectMapper;

    private IAddresRepository addresRepository;

    @Autowired
    public AddressServiceImpl(IAddresRepository addresRepository) {
        this.addresRepository = addresRepository;
    }

    @Override
    public AddressDTO getId(Long id) {
        Optional<Address> address = addresRepository.findById(id);
        AddressDTO addressDTO=null;
        if(address.isPresent())
            addressDTO = objectMapper.convertValue(address, AddressDTO.class);
        return addressDTO;
    }

    @Override
    public Set<AddressDTO> getAll() {
        List<Address> address = addresRepository.findAll();
        Set<AddressDTO> addressDTO = new HashSet<>();
        for(Address add : address){
            addressDTO.add(objectMapper.convertValue(add, AddressDTO.class));
        }
        return addressDTO;
    }

    @Override
    public void save(AddressDTO addressDTO) {
        Address address = objectMapper.convertValue(addressDTO, Address.class);
        addresRepository.save(address);

    }

    @Override
    public void delete(Long id) {
            addresRepository.deleteById(id);

    }

    @Override
    public void update(AddressDTO addressDTO) {
        save(addressDTO);
    }
}
