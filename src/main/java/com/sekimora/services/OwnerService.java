package com.sekimora.services;

import com.sekimora.models.Owner;

import java.util.Optional;

public interface OwnerService {


    Owner save(Owner s);

    Iterable<Owner> getAll();

    void delOne(Integer id_owner);

    long countAll();

    Optional<Owner> findById(Integer id_owner);

}
