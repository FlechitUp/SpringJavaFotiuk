package com.xime.bupho.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.xime.bupho.model.PhotoModel;

public interface PhotoRepository extends PagingAndSortingRepository<PhotoModel, Long>{
	
	List<PhotoModel> findAll();
	
	PhotoModel findById(Long id);
	
	List<PhotoModel> findByName(String name);
	
	List<PhotoModel> findByPrice(Integer price);
	
	
}
