package com.java.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="adress")
@Getter
@Setter
public class Adress {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "adressname")
    private String adressname;


    @Column(name = "city")
    private String city;


    @Column(name = "district")
    private String district;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    public Adress(Long id, String adressname, String city, String district) {
        this.id = id;
        this.adressname = adressname;
        this.city = city;
        this.district = district;
    }
    public Adress(){

    }
}
