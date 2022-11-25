package com.dh.ProyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Table(name="Dentists")
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@NoArgsConstructor
public class DentistDTO {

   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/

    private Long id;
    private String lastname;
    private String name;
    private String tuition;
}
