package com.dh.ProyectoIntegrador.entity.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class TurnDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTurn;
    @Column
    private Date dateTurn;

}
