package com.exudo.DisneyWorldApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exudo.DisneyWorldApi.modelDTO.CharacterDTO;
import com.exudo.DisneyWorldApi.repository.CharacterRepository;



@Service
public class CharacterService {
	
	@Autowired
	CharacterRepository characterRepository;
	
	
	public CharacterDTO newCharacter(@RequestBody CharacterDTO newCharacterDTO) {
		return characterRepository.save(newCharacterDTO);
	}

	
	public List<CharacterDTO> all() {
		return characterRepository.findAll();
	}

	
	public List<CharacterDTO> findByName(@PathVariable String name) {
		return characterRepository.findByName(name);
	}

	
	public List<CharacterDTO> findByAge(@PathVariable Integer age) {
		return characterRepository.findByAge(age);
	}

	
	public CharacterDTO replaceCharacter(@RequestBody CharacterDTO newCharacterDTO, @PathVariable Long id) {

		return characterRepository.findById(id).map(character -> {
			character.setName(newCharacterDTO.getName());
			character.setAge(newCharacterDTO.getAge());
			character.setImgURL(newCharacterDTO.getImgURL());
			character.setStory(newCharacterDTO.getStory());
			character.setFilms(newCharacterDTO.getFilms());

			return characterRepository.save(character);
		}).orElseGet(() -> {
			newCharacterDTO.setId(id);
			return characterRepository.save(newCharacterDTO);
		});
	}

	
	public void deleteCharacter(@PathVariable Long id) {
		characterRepository.deleteById(id);
	}

}
