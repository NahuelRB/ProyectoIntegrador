package com.dh.ProyectoIntegrador.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dentists")
@Setter
@Getter
@NoArgsConstructor
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lastname;

    private String name;

    private String tuition;

    @OneToMany(mappedBy = "dentist", cascade = CascadeType.ALL)
    private List<Turn> turnos;


    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn()
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = )
    private Turn turn;*/


}
