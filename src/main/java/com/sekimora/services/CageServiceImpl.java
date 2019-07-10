package com.sekimora.services;


import com.sekimora.models.Cage;
import com.sekimora.repos.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CageServiceImpl implements CageService {
    private final CageRepository cagrepos;

    @Autowired
    public CageServiceImpl(CageRepository cagrepos) {
        this.cagrepos = cagrepos;
    }


    @Override
    public Iterable<Cage> getAll() {
        return cagrepos.findAll();
    }

    @Override
    public void delOne(Integer id_cage) {
        cagrepos.deleteById(id_cage);
    }

    @Override
    public long countAll() {
        return cagrepos.count();
    }

    @Override
    public Cage save(Cage s) {
        return cagrepos.save(s);
    }

    public Optional<Cage> findById(Integer id_cage) {
        return cagrepos.findById(id_cage);
    }
}