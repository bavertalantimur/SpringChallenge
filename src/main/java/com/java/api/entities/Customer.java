package com.java.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mailadress")
    private String mailadress;

    @Column(name = "password")
    private Long password;

    public Customer(Long id, String mailadress, Long password) {
        this.id = id;
        this.mailadress = mailadress;
        this.password = password;
    }

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<Adress> adresses;

    public Customer() {

    }
}
