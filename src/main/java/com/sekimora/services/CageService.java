package com.sekimora.services;

import com.sekimora.models.Cage;

import java.util.Optional;

public interface CageService {

    Cage save(Cage s);

    Iterable<Cage> getAll();

    void delOne(Integer id_cage);

    long countAll();

    Optional<Cage> findById(Integer id_cage);

}
