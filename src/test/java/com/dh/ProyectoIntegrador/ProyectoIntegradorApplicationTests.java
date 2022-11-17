package com.dh.ProyectoIntegrador;

import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.model.Dentist;
import com.dh.ProyectoIntegrador.repository.impl.DentistaRepository;
import com.dh.ProyectoIntegrador.service.DentistService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
class ProyectoIntegradorApplicationTests {

	@Test
	void contextLoads() {
	}

	/*@Test
	void buscar(){
		DentistService dentistaService = new DentistService(new DentistaRepository());
		Dentist dentistaDto = dentistaService.buscarId(150);
		Assert.assertNotNull(dentistaDto);
	}*/

}
