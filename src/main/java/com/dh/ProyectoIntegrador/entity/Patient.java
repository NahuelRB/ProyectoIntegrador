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
    @GeneratedValue(strategy = GenerationType.AUTO)//Para ponerla como id principal
    private Long id;
    //@Column(nullable = false)//No admite nulos con false con true si, cuando se tenga que ingresar un dato
    private String name;
    //@Column(nullable = false)
    private String lastname;
    //@Column(nullable = false)
    private String address;
    //@Column(nullable = false)
    private String dni;
    //@Column(nullable = false)
    private String highdate;

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="id_dentist")
    private Dentist dentist;

    //@OneToOne(mappedBy = "")
    @JoinColumn(name="id_turn", referencedColumnName = "id")
    private Turn turn;*/
}
