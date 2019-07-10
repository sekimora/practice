package com.sekimora.services;


import com.sekimora.models.Animal;
import com.sekimora.repos.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animrepos;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animrepos) {
        this.animrepos = animrepos;
    }

    public Iterable<Animal> getAll() {
        return animrepos.findAll();
    }

    public void delOne(Integer id_animal) {
        animrepos.deleteById(id_animal);
    }

    public long countAll() {
        return animrepos.count();
    }


    @Override
    public Animal save(Animal an) {
        return animrepos.save(an);
    }

    public Iterable<Animal> findByOwnerId(Integer id_owner) {
        return animrepos.getAllByOwnerId(id_owner);
    }

    public Iterable<Animal> findByCageId(Integer id_cage) {
        return animrepos.getByCageId(id_cage);
    }


}