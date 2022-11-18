package com.dh.ProyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@AllArgsConstructor - Creo que no lo necesita en DTO
@Data//Me crea todos los getters y setters de las variables
@Entity// Para la base de datos con ORM
@Table(name = "dentists")//Va a crear una tabla en la base de datos con el nombre dentists si no lo tiene
@NoArgsConstructor//Crea un constructor sin parametros
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IId;
    @Column(nullable = false)
    private String SLastname;
    @Column(nullable = false)
    private String SName;
    @Column(length = 15, nullable = false)
    private String STuition;
}