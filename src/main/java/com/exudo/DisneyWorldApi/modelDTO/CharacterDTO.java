package com.exudo.DisneyWorldApi.modelDTO;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Entity
@Table(name = "characters")
public class CharacterDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "weight")
	private Integer weight;

	@Column(name = "story")
	private String story;

	@Column(name = "imgURL")
	private String imgURL;
	
	@ManyToMany(mappedBy = "charaters", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FilmDTO> films; 
	

}
