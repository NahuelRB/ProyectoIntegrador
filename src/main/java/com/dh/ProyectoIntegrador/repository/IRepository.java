package com.dh.ProyectoIntegrador.repository;

import java.util.List;

public interface IRepository<T> {

    T save(T t);
    T getId(int id);
    List<T> getAll();
    T update(T t);
    Boolean delete(int id);

}
