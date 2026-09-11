package com.petstore.jpa;

import com.petstore.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TagRepository extends JpaRepository<Tag,Long> {

    public Set<Tag> findAllByNameIn(List<String> name);
}
