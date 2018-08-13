package com.bridgelabz.microservice.fundoonote.user.repositories;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.bridgelabz.microservice.fundoonote.user.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	public Optional<User> findByEmail(String email);

	public void save(Optional<User> user);

}