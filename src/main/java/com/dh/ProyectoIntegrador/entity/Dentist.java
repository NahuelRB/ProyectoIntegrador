package com.dh.ProyectoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="dentists")
@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastname;

    private String name;

    private String tuition;

    /*@ManyToMany(mappedBy = "dentistas")
    private Set<Patient> pacientes;*/

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set <Turn> turns = new HashSet<>();


    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn()
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = )
    private Turn turn;*/
}
