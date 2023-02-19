package com.java.api.business;

import com.java.api.dto.AdressDto;
import com.java.api.dto.CustomerDto;
import com.java.api.entities.Adress;

import java.security.InvalidKeyException;
import java.util.List;

public interface IAdressService {
    void create(AdressDto adressDto);
    List<AdressDto> getAll();
    void update(AdressDto adressDto,Long id);
    void delete(Long id) throws InvalidKeyException;
    AdressDto getAdressById(Long id);
}
