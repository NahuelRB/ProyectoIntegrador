package com.dh.ProyectoIntegrador.entity.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PatientDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Para ponerla como id principal
    private Long idPatient;
    @Column(nullable = false)//No admite nulos con false con true si, cuando se tenga que ingresar un dato
    private String name;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String dni;
    @Column(nullable = false)
    private String highdate;

}
