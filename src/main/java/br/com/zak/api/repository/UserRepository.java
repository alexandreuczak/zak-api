package br.com.zak.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zak.api.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByName(String name);
	
}
