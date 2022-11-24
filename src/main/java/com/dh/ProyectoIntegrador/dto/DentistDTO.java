package com.dh.ProyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Dentists")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lastname;
    private String name;
    private String tuition;
}
