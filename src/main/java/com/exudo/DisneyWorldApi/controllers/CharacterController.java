package com.exudo.DisneyWorldApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exudo.DisneyWorldApi.modelDTO.CharacterDTO;
import com.exudo.DisneyWorldApi.services.CharacterService;

;


@RestController
@RequestMapping("/characters")
public class CharacterController {

	@Autowired
	CharacterService characterService;
	
	@PostMapping()
	public CharacterDTO newCharacter(@RequestBody CharacterDTO newCharacterDTO) {
		return characterService.newCharacter(newCharacterDTO);
	}

	@RequestMapping()
	public List<CharacterDTO> all() {
		return characterService.all();
	}

	@RequestMapping("/name")
	public List<CharacterDTO> findByName(@RequestParam("name") String name) {
		return  this.characterService.findByName(name);
	}

	@RequestMapping("/age")
	public List<CharacterDTO> findByAge(@RequestParam("age") Integer age) {
		return this.characterService.findByAge(age);
	}

	@PutMapping("/characters/{id}")
	public CharacterDTO replaceCharacter(@RequestBody CharacterDTO newCharacterDTO, @PathVariable Long id) {

		return characterService.replaceCharacter(newCharacterDTO, id);
	}

	@DeleteMapping(path = "/{id}")
	public void deleteCharacter(@PathVariable("id") Long id) {
		characterService.deleteCharacter(id);
	}
	
}
