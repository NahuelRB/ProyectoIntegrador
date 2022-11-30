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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    @Id
    private Long id;
    private String nameAddress;
    private int number;
    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Patient patient;

}
