package com.dh.ProyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnDTO {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/

    private String date_turn;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dentist_id")
    private Set<Dentist> dentists = new HashSet<>();*/

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Set<Patient> patients = new HashSet<>();*/

}
