package com.petstore.api;


import com.petstore.jpa.CategoryRepository;
import com.petstore.jpa.TagRepository;
import com.petstore.model.Category;
import com.petstore.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.petstore.jpa.PetRepository;

import com.petstore.model.Pet;

import java.util.List;
import java.util.Set;

@Component
@Slf4j
public class PetstoreImpl implements V2ApiDelegate {

    private final PetRepository petRepo;
    private final TagRepository tagRepo;
    private final CategoryRepository categoryRepo;

    public PetstoreImpl(PetRepository petRepo, TagRepository tagRepo, CategoryRepository categoryRepo) {
        this.petRepo = petRepo;
        this.tagRepo = tagRepo;
        this.categoryRepo = categoryRepo;
    }

    public ResponseEntity<Void> addPet(Pet pet) {
        try {
            this.petRepo.save(pet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<Pet> getPetById(Long petId) {
        try {
            Pet pet = this.petRepo.findById(petId).orElseThrow(() -> new IllegalArgumentException("not found"));
            return new ResponseEntity<>(pet, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage(), e);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Pet>> findPetsByTags(List<String> tags) {
        Set<Tag> matchingTags = this.tagRepo.findAllByNameIn(tags);
        if (matchingTags.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Pet> pets = this.petRepo.findPetsByTagsIn(matchingTags).stream().toList();

        return ResponseEntity.ok(pets);
    }
}
