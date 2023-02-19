package com.java.api.controller;

import com.java.api.business.IAdressService;
import com.java.api.dto.AdressDto;
import com.java.api.dto.AdressResponses;
import com.java.api.dto.CustomerDto;
import com.java.api.dto.CustomerResponses;
import com.java.api.entities.Adress;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adress")
@Getter
@Setter
public class AddressController {

    @Autowired
    private IAdressService adressService;

    public AddressController(IAdressService adressService) {
        this.adressService = adressService;
    }
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity<AdressResponses> create(@RequestBody AdressDto adress)
    {
        try {

            adressService.create(adress);
            return ResponseEntity.status(201).body(new AdressResponses(201,"success","succes"));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(424).body(new AdressResponses(424,"fail","fail"));}
    }
    @GetMapping("all")
    public ResponseEntity<AdressResponses>getAll(){
        if(adressService.getAll().isEmpty())
            return ResponseEntity.status(404).body(new AdressResponses(404,"fail",""));
        return ResponseEntity.status(200).body(new AdressResponses(200,"success","get all",adressService.getAll()));
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<AdressResponses> delete(@PathVariable Long id){
        try {
            adressService.delete(id);
            return ResponseEntity.status(204).body(new AdressResponses(204,"success","deleted"));
        }
        catch (Exception e){
            return ResponseEntity.status(400).body(new AdressResponses(400,"fail","not deleted"));
        }

    }
    @PutMapping("update/{id}")
    public ResponseEntity<AdressResponses> update(@RequestBody AdressDto adressDto, @PathVariable Long id){
        try {
            adressService.update(adressDto,id);
            return ResponseEntity.status(200).body(new AdressResponses(200,"succes","updated"));

        }catch (Exception e){
            return ResponseEntity.status(400).body(new AdressResponses(400,"fail","not updated"));
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<AdressResponses> getAdressById(@PathVariable Long id){
        try {
            AdressDto adressDto=adressService.getAdressById(id);
            return ResponseEntity.status(200).body(new AdressResponses(200,"success","Address find by id",List.of(adressDto)));
        }catch (Exception e){
            return ResponseEntity.status(400).body(new AdressResponses(400,"fail","not find id"));
        }
    }





}
