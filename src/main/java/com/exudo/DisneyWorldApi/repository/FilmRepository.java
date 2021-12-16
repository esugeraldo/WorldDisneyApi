package com.exudo.DisneyWorldApi.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exudo.DisneyWorldApi.modelDTO.FilmDTO;



@Repository
public interface FilmRepository extends JpaRepository<FilmDTO, Long>{

	public abstract List<FilmDTO> findByTitle(String title);
	public abstract List<FilmDTO> findByOrderByRealeaseDateAsc();
	public abstract List<FilmDTO> findByOrderByRealeaseDateDesc();

	
	
}
