package com.dh.ProyectoIntegrador.entity;

import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="turns")
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date_turn;

   /* private Long dentist_id;

    private Long patient_id;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dentist_id")
    @JsonIgnore
    private Dentist dentist;
    //private Set<Dentist> dentists = new HashSet<>();

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id", referencedColumnName = "id")
    private Patient patient;*/

    //private Set<Patient> patients = new HashSet<>();

    /*@ManyToOne(fetch = FetchType.LAZY)
    private Set<Dentist> dentists = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();*/
}
