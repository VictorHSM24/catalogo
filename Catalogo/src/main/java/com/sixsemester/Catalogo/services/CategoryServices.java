package com.sixsemester.Catalogo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sixsemester.Catalogo.dto.CategoryDTO;
import com.sixsemester.Catalogo.entities.Category;
import com.sixsemester.Catalogo.repositories.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		
		List<CategoryDTO> listDTO = list.stream().map(x -> new CategoryDTO(x))
				.collect(Collectors.toList());
		
		return listDTO;
	}
	
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.get();
		return new CategoryDTO(entity);
	}
}
