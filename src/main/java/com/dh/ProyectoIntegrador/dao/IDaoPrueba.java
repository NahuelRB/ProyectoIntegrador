package com.dh.ProyectoIntegrador.dao;

import java.util.List;

public interface IDaoPrueba<T> {

    List<T> buscarTodos();

    T buscar(int id);

}
