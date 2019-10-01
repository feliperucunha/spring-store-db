package com.felipecunha.cursomc.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipecunha.cursomc.domain.Post;
import com.felipecunha.cursomc.domain.User;
import com.felipecunha.cursomc.dto.AuthorDTO;
import com.felipecunha.cursomc.repository.PostRepository;
import com.felipecunha.cursomc.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vê se morre!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/03/2018"), "Bora pra Viagem", "Vê se morre logo!", new AuthorDTO(maria));

		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
