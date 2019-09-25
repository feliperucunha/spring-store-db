package com.felipecunha.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipecunha.cursomc.domain.User;
import com.felipecunha.cursomc.dto.UserDTO;
import com.felipecunha.cursomc.repository.UserRepository;
import com.felipecunha.cursomc.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User fromDTO(UserDTO objDto) { //não está no UserDTO, pois por aqui pode acessar também o banco de dados
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}