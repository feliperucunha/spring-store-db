package com.felipecunha.cursomc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.felipecunha.cursomc.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> { //gerencia usar e o ID que é do tipo string

}