package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceImplTest {

    @Autowired
    private IPatientService patientService;

    public void testPatientCreate(){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Nahuel");
        patientDTO.setLastname("Barbosa");
        patientDTO.setDni("35403946");
        //patientDTO.setAddress("11 de septiembre 2070");
        patientDTO.setHighdate("11-10-1990");
        patientService.save(patientDTO);
        PatientDTO patientPrueba = patientService.getId(patientDTO.getId());
        assertTrue(patientPrueba != null);
    }

}