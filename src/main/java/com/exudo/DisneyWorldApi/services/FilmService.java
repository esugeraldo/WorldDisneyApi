package com.exudo.DisneyWorldApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exudo.DisneyWorldApi.modelDTO.FilmDTO;
import com.exudo.DisneyWorldApi.repository.FilmRepository;



@Service
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	
	public FilmDTO newFIlm(@RequestBody FilmDTO newFilmDTO) {
		return filmRepository.save(newFilmDTO);
	}
	

	public List<FilmDTO> all(){
		return filmRepository.findAll(); 
	}

	public List<FilmDTO> findByTitle(@PathVariable String name) {
		return filmRepository.findByTitle(name);
	}

//	public FilmDTO findByGenre(@PathVariable Long id) {
//		
//	}
	

	public List<FilmDTO> sortListAsc() {
		return filmRepository.findByOrderByRealeaseDateAsc();
	}

	public List<FilmDTO> sortListDesc() {
		return filmRepository.findByOrderByRealeaseDateDesc();
	}
	

	public FilmDTO replaceFilm(@RequestBody FilmDTO newFilmDTO, @PathVariable Long id) {
		return filmRepository.findById(id)		
		.map(filmDTO -> {
			filmDTO.setTitle(newFilmDTO.getTitle());
			filmDTO.setImgUrl(newFilmDTO.getImgUrl());
			filmDTO.setRealeaseDate(newFilmDTO.getRealeaseDate());
			filmDTO.setCalification(newFilmDTO.getCalification());
			filmDTO.setCharaters(newFilmDTO.getCharaters());	
			return filmRepository.save(newFilmDTO);
		}).orElseGet(()->{
			newFilmDTO.setId(id);
			return filmRepository.save(newFilmDTO);
		});
	}
	
	public void deleteFilm(@PathVariable Long id) {
		filmRepository.deleteById(id);
	}

}
