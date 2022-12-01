package com.dh.ProyectoIntegrador.service;

import com.dh.ProyectoIntegrador.dto.AddressDTO;

import java.util.Set;

public interface IAddressService {

    AddressDTO getId(Long id);

    Set<AddressDTO> getAll();

    AddressDTO save(AddressDTO addressDTO);

    void delete(Long id);

    void update(AddressDTO addressDTO);
}
