package com.exudo.DisneyWorldApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exudo.DisneyWorldApi.modelDTO.GenreDTO;
import com.exudo.DisneyWorldApi.services.GenreService;



@RestController
public class GenreController {
	
	@Autowired
	GenreService genreService;
	

	@GetMapping("/genre")
	public List<GenreDTO> all(){
		return genreService.all();
	}
	
	@GetMapping("/genre/{id}")
	public GenreDTO one(@PathVariable Long id) {
		return genreService.one(id);
	}
	
	@PostMapping("/genre")
	public GenreDTO newGenreDTO(@RequestBody GenreDTO newGenreDTO) {
		return genreService.newGenreDTO(newGenreDTO);
	}
	@DeleteMapping("/genre/{id}")
	public void deleteGenreDTO(@PathVariable Long ID) {
		genreService.deleteGenreDTO(ID);
	}

}
