package com.dh.ProyectoIntegrador.dto;

import com.dh.ProyectoIntegrador.entity.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO{

    private Long id;
    private String name;
    private String lastname;
    //private String address;
    private String dni;
    private String highdate;

}
