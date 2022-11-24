package com.dh.ProyectoIntegrador.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTurn;
    @Column
    private Date dateTurn;

    /*@ManyToMany
    private Turn turn;

    @ManyToOne(fetch = FetchType.LAZY)
    private Set<Dentist> dentists = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Set<Patient> patients = new HashSet<>();*/
}
