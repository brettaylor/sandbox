package com.petstore.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petstore.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
