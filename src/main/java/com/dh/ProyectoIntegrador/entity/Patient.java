package com.dh.ProyectoIntegrador.entity;

import lombok.*;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patients")
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable = false)
    private String SName;
    @Column(nullable = false)
    private String SLastname;
    @Column(nullable = false)
    private String SAddress;
    @Column(nullable = false)
    private String SDni;
    @Column(nullable = false)
    private String SHighdate;

}
