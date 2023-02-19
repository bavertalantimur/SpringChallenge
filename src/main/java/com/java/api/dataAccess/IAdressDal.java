package com.java.api.dataAccess;

import com.java.api.entities.Adress;
import com.java.api.entities.Customer;

import java.security.InvalidKeyException;
import java.util.List;

public interface IAdressDal {
    void create(Adress adress);
    List<Adress> getAll();
    Adress update(Adress adress);
    void delete(Long id) throws InvalidKeyException;
    Adress getAdressById(Long id);

}
