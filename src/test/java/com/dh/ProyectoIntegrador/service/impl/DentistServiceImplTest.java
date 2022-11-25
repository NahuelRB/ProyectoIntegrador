package com.dh.ProyectoIntegrador.service.impl;

import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.dto.PatientDTO;
import com.dh.ProyectoIntegrador.service.IDentistService;
import com.dh.ProyectoIntegrador.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DentistServiceImplTest {


    @Autowired
    private IDentistService dentistService;

    public void testDentistCreate(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Nahuel");
        dentistDTO.setLastname("Barbosa");
        dentistDTO.setTuition("NFU010");
        dentistService.save(dentistDTO);
        DentistDTO dentistPrueba = dentistService.getId(dentistDTO.getId());
        assertTrue(dentistPrueba != null);
    }

}