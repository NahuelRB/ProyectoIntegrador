package com.dh.ProyectoIntegrador.dto;

import com.dh.ProyectoIntegrador.entity.Address;
import com.dh.ProyectoIntegrador.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Setter
@Getter
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDTO {

        //private Long id;
        private String name_address;
        private int number;
        private String country;

        @OneToOne
        @JoinColumn(name="patient_id")
        private Patient patient;


}
