package com.java.api.business;

import com.java.api.dataAccess.IAdressDal;
import com.java.api.dto.AdressDto;
import com.java.api.dto.CustomerDto;
import com.java.api.entities.Adress;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class  AdressManager implements IAdressService {
    @Autowired
    private IAdressDal adressDal;

    private final ModelMapper modelMapper;
    @Override
    @Transactional
    public void create(AdressDto adressDto) {
        Adress adress = modelMapper.map(adressDto, Adress.class);
        adressDal.create(adress);
    }

    @Override
    public List<AdressDto> getAll() {
        List<AdressDto> adressDtos=new ArrayList<>();
        adressDal.getAll().forEach(employee->adressDtos.add(modelMapper.map(employee,AdressDto.class)));
        return adressDtos;
    }

    @Override
    public void update(AdressDto adressDto,Long id) {
        Adress address=modelMapper.map(adressDto,Adress.class);
        address.setId(id);
        adressDal.update(address);
    }

    @Override
    public void delete(Long id)throws InvalidKeyException {
        adressDal.delete(id);
    }

    @Override
    public AdressDto getAdressById(Long id) {
        AdressDto customerDto=modelMapper.map(adressDal.getAdressById(id),AdressDto.class);
        return customerDto;
    }

}
