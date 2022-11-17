package com.dh.ProyectoIntegrador.repository.impl;

import com.dh.ProyectoIntegrador.dao.IDaoPrueba;
import com.dh.ProyectoIntegrador.dto.DentistDTO;
import com.dh.ProyectoIntegrador.util.Jsons;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


import java.util.List;

public class DentistaRepository implements IDaoPrueba<DentistDTO> {


    @Override
    public List buscarTodos() {
        return null;
    }

    public DentistDTO buscar(int id) {
        HttpResponse<String> response=null;
        DentistDTO dentista = null;

        try {
            response = Unirest.get("https://pokeapi.co/api/v2/pokemon/150").asString();
            dentista = Jsons.objectFromString(DentistDTO.class, response.getBody());
        } catch (UnirestException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return dentista;
    }


}
