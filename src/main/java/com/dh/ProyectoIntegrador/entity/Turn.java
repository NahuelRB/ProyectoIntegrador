package com.dh.ProyectoIntegrador.entity;

import java.util.Date;

public class Turn {

    private Date DFechaHora;
    private Dentist dentist;
    private Patient patient;

    public Turn() {
    }

    public Turn(Date DFechaHora, Dentist dentist, Patient patient) {
        this.DFechaHora = DFechaHora;
        this.dentist = dentist;
        this.patient = patient;
        }

    public Date getDFechaHora() {
        return DFechaHora;
    }

    public void setDFechaHora(Date DFechaHora) {
        this.DFechaHora = DFechaHora;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
