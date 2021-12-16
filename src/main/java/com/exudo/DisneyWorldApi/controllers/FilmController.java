package com.exudo.DisneyWorldApi.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exudo.DisneyWorldApi.modelDTO.FilmDTO;
import com.exudo.DisneyWorldApi.services.FilmService;





@RestController
@RequestMapping("/movies")
public class FilmController {

	@Autowired
	FilmService filmService;
	
	
	@PostMapping()
	public FilmDTO newFIlmDTO(@RequestBody FilmDTO newFilmDTO) {
		return filmService.newFIlm(newFilmDTO);
	}
	
	@GetMapping()
	public List<FilmDTO> all(){
		return filmService.all(); 
	}
	@RequestMapping("/title")
	public List<FilmDTO> findByTitle(@RequestParam String title) {
		return filmService.findByTitle(title);
	}
//	@RequestMapping("/movies/{genre}")
//	public FilmDTO findByGenre(@PathVariable Long id) {
//		
//	}
	
	@RequestMapping("/orderAsc")
	public List<FilmDTO> sortListAsc() {
		return filmService.sortListAsc();
	}
	@RequestMapping("/orderDesc")
	public List<FilmDTO> sortListDesc() {
		return filmService.sortListDesc();
	}
	
	@PutMapping("/movies/{id}")
	public FilmDTO replaceFilmDTO(@RequestBody FilmDTO newFilmDTO, @PathVariable Long id) {
		return filmService.replaceFilm(newFilmDTO, id);
	}
	@DeleteMapping("/movies")
	public void deleteFilm(@PathVariable Long id) {
		filmService.deleteFilm(id);
	}
	
}
