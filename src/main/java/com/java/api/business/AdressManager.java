package com.java.api.business;

import com.java.api.dataAccess.IAdressDal;
import com.java.api.entities.Adress;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdressManager implements IAdressService {
    @Autowired
    private IAdressDal adressDal;
    @Override
    @Transactional
    public void addAddress(Adress adress) {
        adressDal.addAddress(adress);
    }

    @Override
    public List<Adress> getAll() {
        return adressDal.getAll();
    }

    @Override
    public void update(Adress adress) {
        adressDal.update(adress);
    }

    @Override
    public void delete(Long id) {
        adressDal.delete(id);
    }

}
