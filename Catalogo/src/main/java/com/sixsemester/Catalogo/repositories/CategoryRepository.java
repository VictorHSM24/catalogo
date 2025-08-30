package com.sixsemester.Catalogo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sixsemester.Catalogo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
