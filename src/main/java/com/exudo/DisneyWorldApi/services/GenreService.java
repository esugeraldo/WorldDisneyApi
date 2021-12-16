package com.exudo.DisneyWorldApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.exudo.DisneyWorldApi.modelDTO.GenreDTO;
import com.exudo.DisneyWorldApi.repository.GenreRepository;



@Service
public class GenreService {
	
	@Autowired
	GenreRepository genreRepository;
	


	public List<GenreDTO> all(){
		return genreRepository.findAll();
	}
	

	public GenreDTO one(@PathVariable Long id) {
		return genreRepository.getById(id);
	}
	

	public GenreDTO newGenreDTO(@RequestBody GenreDTO newGenreDTO) {
		return genreRepository.save(newGenreDTO);
	}

	public void deleteGenreDTO(@PathVariable Long ID) {
		genreRepository.deleteById(ID);
	}
}
