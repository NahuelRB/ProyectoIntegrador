package com.dh.ProyectoIntegrador.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table(name="dentists")
@NoArgsConstructor
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String lastname;

    private String name;

    private String tuition;

    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn()
    private Patient patient;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = )
    private Turn turn;*/


}
