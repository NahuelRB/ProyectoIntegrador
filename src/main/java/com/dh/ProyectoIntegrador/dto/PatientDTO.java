package com.dh.ProyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="patients")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class PatientDTO{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Para ponerla como id principal
    private Long id;
    //@Column(nullable = false)//No admite nulos con false con true si, cuando se tenga que ingresar un dato
    private String name;
    //@Column(nullable = false)
    private String lastname;
    //@Column(nullable = false)
    private String address;
    //@Column(nullable = false)
    private String dni;
    //@Column(nullable = false)
    private String highdate;

}
