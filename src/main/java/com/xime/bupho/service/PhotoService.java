package com.xime.bupho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xime.bupho.model.PhotoModel;
import com.xime.bupho.repository.PhotoRepository;

@Service
public class PhotoService {
	
	private final PhotoRepository repository;
		
	@Autowired
	public PhotoService(PhotoRepository repository) {
		this.repository = repository;
	}
	
	public List<PhotoModel> findAll() {
	    return this.repository.findAll();
	}
	
	
	public PhotoModel findById(Long id) {
	    return this.repository.findOne(id);
	}

}
