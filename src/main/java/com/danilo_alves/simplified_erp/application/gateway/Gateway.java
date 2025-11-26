package com.danilo_alves.simplified_erp.application.gateway;

import java.util.List;

public interface Gateway<T, ID> {
    T save(T object);

    T update(T object);

    void delete(ID id);

    List<T> getAll();

    T getById(ID id);
}
