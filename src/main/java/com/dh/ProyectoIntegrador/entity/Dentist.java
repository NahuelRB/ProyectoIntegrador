package com.dh.ProyectoIntegrador.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="dentist")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDentist;
    @Column(nullable = false, name = "lastname")
    private String lastname;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(length = 15, nullable = false, name = "tuition")
    private String tuition;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn()
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = )
    private Turn turn;*/


}
