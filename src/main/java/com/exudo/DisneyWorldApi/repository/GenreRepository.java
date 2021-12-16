package com.exudo.DisneyWorldApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exudo.DisneyWorldApi.modelDTO.GenreDTO;



@Repository
public interface GenreRepository extends JpaRepository<GenreDTO, Long> {

}
