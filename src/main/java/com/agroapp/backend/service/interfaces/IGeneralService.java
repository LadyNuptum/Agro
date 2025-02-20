package com.agroapp.backend.service.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    List<T> getAll();

    Optional<T> getById(Integer id);

    T create(T entity);

    T updateById(Integer id, T entity);

    void deleteById(Integer id);
}
