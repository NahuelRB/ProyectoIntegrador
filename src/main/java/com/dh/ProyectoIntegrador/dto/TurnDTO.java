package com.dh.ProyectoIntegrador.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name="turns")
@Setter
@Getter
@NoArgsConstructor
public class TurnDTO {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    private String dateTurn;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dentist_id")
    private Set<Dentist> dentists = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Set<Patient> patients = new HashSet<>();*/

}
