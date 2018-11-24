package br.com.zak.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zak.api.domain.Greeting;

@Repository
public interface GrettingRepository extends JpaRepository<Greeting, Long>{

}
