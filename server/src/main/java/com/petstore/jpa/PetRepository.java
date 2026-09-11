package com.petstore.jpa;

import com.petstore.model.Tag;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.petstore.model.Pet;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;
import java.util.Set;

public interface  PetRepository extends JpaRepository<Pet, Long> {

    /*
     * This operation is an example of setting the jpa.open-in-view to false.
     * Attribute paths need to be Sets and not List objects when open-in-view is set to false,
     * this is considered a best practice (set to false) to prevent the UI from starving DB connections.
     */
    @EntityGraph(attributePaths = {"tags","photoUrls","category"})
    Set<Pet> findPetsByTagsIn(Set<@Valid Tag> tags);

}
