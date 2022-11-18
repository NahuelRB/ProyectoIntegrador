package com.dh.ProyectoIntegrador.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="dentists")
@NoArgsConstructor
@AllArgsConstructor
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IId;
    @Column(nullable = false)
    private String SLastname;
    @Column(nullable = false)
    private String SName;
    @Column(length = 15, nullable = false)
    private String STuition;


}
