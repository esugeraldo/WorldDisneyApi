package com.exudo.DisneyWorldApi.modelDTO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "geners")
public class GenreDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;	
	@Column(name = "name")
	private String name;
	@Column(name ="imgUrl")
	private String imgUrl;
	@OneToMany(targetEntity = FilmDTO.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "film_genere", referencedColumnName = "")
	private List<FilmDTO> films;


}
