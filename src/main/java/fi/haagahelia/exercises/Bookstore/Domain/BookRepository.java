package fi.haagahelia.exercises.Bookstore.Domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;



@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByAuthor(@Param("author") String author);
	
	//Enabling ignoring case
	
}
