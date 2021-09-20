package fi.haagahelia.exercises.Bookstore.Domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;




public interface BookRepository extends CrudRepository<Book, Long>{

	List<Book> findByAuthor(String author);
	//Enabling ignoring case
	
}
