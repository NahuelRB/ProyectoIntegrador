package com.dh.ProyectoIntegrador.entity;

import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
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
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String dateTurn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dentist_id")
    private Dentist dentist;
    //private Set<Dentist> dentists = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;
    //private Set<Patient> patients = new HashSet<>();

    /*@ManyToOne(fetch = FetchType.LAZY)
    private Set<Dentist> dentists = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();*/
}
