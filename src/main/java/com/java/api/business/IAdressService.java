package com.java.api.business;

import com.java.api.entities.Adress;

import java.util.List;

public interface IAdressService {
    void addAddress(Adress adress);
    List<Adress> getAll();
    void update(Adress adress);
    void delete(Long id);
}
