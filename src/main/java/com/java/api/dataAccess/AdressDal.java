package com.java.api.dataAccess;

import com.java.api.entities.Adress;
import com.java.api.entities.Customer;
import com.java.api.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.List;
import java.util.Optional;


@Repository
public class AdressDal implements IAdressDal {
    private AdressRepository adressRepository;
    @Autowired
    public AdressDal(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }


    @Override
    public void create(Adress adress) {
        adressRepository.save(adress);
    }

    @Override
    public List<Adress> getAll() {
        return adressRepository.findAll();
    }

    @Override
    public Adress update(Adress adress) {
        Adress adress1=adressRepository.findById(adress.getId()).orElse(null);

            if (!adress.getAdressname().isEmpty())
                adress1.setAdressname(adress.getAdressname()); ;//f:alihan
            if (!adress.getCity().isEmpty()) //
                adress1.setCity(adress.getCity());

        return adressRepository.save(adress1);
    }

    @Override
    public void delete(Long id)throws InvalidKeyException {
        try{
            adressRepository.deleteById(id);
        }catch (Exception e){
            throw new InvalidKeyException("Something went wrong");
        }
    }

    @Override
    public Adress getAdressById(Long id) {
        return adressRepository.findById(id).orElse(null);
    }
}
