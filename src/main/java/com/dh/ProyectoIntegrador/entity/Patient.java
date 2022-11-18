package com.dh.ProyectoIntegrador.entity;

import lombok.*;
import javax.persistence.*;


@AllArgsConstructor
@Data//Me crea todos los getters y setters de las variables
@Entity// Para la base de datos con ORM
@Table(name="patients")//Va a crear una tabla en la base de datos con el nombre patients si no lo tiene
@NoArgsConstructor//Crea un constructor sin parametros
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Para ponerla como id principal
    private int Id;
    @Column(nullable = false)//No admite nulos con false con true si, cuando se tenga que ingresar un dato
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
