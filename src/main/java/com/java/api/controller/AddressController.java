package com.java.api.controller;

import com.java.api.business.IAdressService;
import com.java.api.entities.Adress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@Getter
@Setter
public class AddressController {

    @Autowired
    private IAdressService adressService;

    public AddressController(IAdressService adressService) {
        this.adressService = adressService;
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public void addAddress(@RequestBody Adress adress){
        adressService.addAddress(adress);
    }

    @GetMapping("all")
    public List<Adress> getAll(){
        return adressService.getAll();
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public void update(@RequestBody Adress adress){
        adressService.addAddress(adress);
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id){
        adressService.delete(id);
    }

}
