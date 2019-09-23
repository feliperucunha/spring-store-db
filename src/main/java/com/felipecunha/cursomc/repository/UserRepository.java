package com.felipecunha.cursomc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipecunha.cursomc.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> { //gerencia usar e o ID que é do tipo string

}