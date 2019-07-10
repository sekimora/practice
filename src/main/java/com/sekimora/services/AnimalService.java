package com.sekimora.services;

import com.sekimora.models.Animal;

public interface AnimalService {

    Animal save(Animal an);

    Iterable<Animal> getAll();

    void delOne(Integer id_animal);

    long countAll();

    Iterable<Animal> findByOwnerId(Integer id_owner);

    Iterable<Animal> findByCageId(Integer id_cage);


}
