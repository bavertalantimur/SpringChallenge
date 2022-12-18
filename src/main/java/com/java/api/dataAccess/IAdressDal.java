package com.java.api.dataAccess;

import com.java.api.entities.Adress;
import com.java.api.entities.Customer;

import java.util.List;

public interface IAdressDal {
    void addAddress(Adress adress);
    List<Adress> getAll();
    void update(Adress adress);
    void delete(Long id);

}
