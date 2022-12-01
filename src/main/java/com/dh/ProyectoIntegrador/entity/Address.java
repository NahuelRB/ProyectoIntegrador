package com.dh.ProyectoIntegrador.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="address")
@Setter
@Getter
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_address;
    private int number;
    private String country;
    @OneToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


}
