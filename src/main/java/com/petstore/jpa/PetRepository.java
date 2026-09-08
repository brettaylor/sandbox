package com.petstore.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petstore.model.Pet;

public interface  PetRepository extends JpaRepository<Pet, Long> {

}
