package com.codegym.service;

import com.codegym.model.Smartphone;

import java.util.Optional;

public interface ISmartpphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
