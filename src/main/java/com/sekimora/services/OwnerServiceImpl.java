package com.sekimora.services;


import com.sekimora.models.Owner;
import com.sekimora.repos.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownrepos;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownrepos) {
        this.ownrepos = ownrepos;
    }


    //@Override
    public Iterable<Owner> getAll() {
        return ownrepos.findAll();
    }

    public void delOne(Integer id_owner) {
        ownrepos.deleteById(id_owner);
    }

    //@Override
    public long countAll() {
        return ownrepos.count();
    }


    @Override
    public Owner save(Owner s) {
        return ownrepos.save(s);
    }

    public Optional<Owner> findById(Integer id_owner) {
        return ownrepos.findById(id_owner);
    }


}
