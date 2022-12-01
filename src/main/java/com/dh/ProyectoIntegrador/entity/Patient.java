package com.dh.ProyectoIntegrador.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="patients")
@Getter
@Setter
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    //private String address;
    private String dni;
    private String highdate;

    @OneToOne(mappedBy = "patient")
    @JsonIgnore
    private Address address;


    /*@ManyToMany
    @JoinTable(name="turns",
                joinColumns = @JoinColumn(name = "dentist_id"),
                inverseJoinColumns = @JoinColumn(name = "patient_id"))
    @JsonIgnore
    private Set<Dentist> dentistas;*/

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_dentist")
    private Dentist dentist;

    //@OneToOne(mappedBy = "")
    @JoinColumn(name="id_turn", referencedColumnName = "id")
    private Turn turn;*/
}
