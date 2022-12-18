package com.java.api.dataAccess;

import com.java.api.entities.Adress;
import com.java.api.entities.Customer;
import com.java.api.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AdressDal implements IAdressDal {
    private AdressRepository adressRepository;
    @Autowired
    public AdressDal(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }


    @Override
    public void addAddress(Adress adress) {
        adressRepository.save(adress);
    }

    @Override
    public List<Adress> getAll() {
        return adressRepository.findAll();
    }

    @Override
    public void update(Adress adress) {
        adressRepository.save(adress);
    }

    @Override
    public void delete(Long id) {
        adressRepository.deleteById(id);
    }
}
