package com.java.api.repository;
import com.java.api.entities.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress,Long> {
}
