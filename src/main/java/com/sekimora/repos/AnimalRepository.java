package com.sekimora.repos;

import com.sekimora.models.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AnimalRepository extends CrudRepository<Animal, Integer> {

    @Query(value = "select * from Animal i where i.id_owner = :ownerID", nativeQuery = true)
    Iterable<Animal> getAllByOwnerId(@Param("ownerID") Integer ownerID);

    @Query(value = "select i from Animal i where i.id_cage = :cageID")
    Iterable<Animal> getAllByCageId(@Param("cageID") Integer cageID);


    @Query(value = "select * from Animal a where a.id_cage = :cageID", nativeQuery = true)
    Iterable<Animal> getByCageId(@Param("cageID") Integer cageID);

}
