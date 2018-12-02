package br.com.zak.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zak.api.domain.User;
import br.com.zak.api.encoder.PasswordEncoder;
import br.com.zak.api.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> listAll(){
		List<User> users = userRepository.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.OK);
	}
}
