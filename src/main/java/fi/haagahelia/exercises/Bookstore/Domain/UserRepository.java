package fi.haagahelia.exercises.Bookstore.Domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	 User findByUsername(String username);
	}