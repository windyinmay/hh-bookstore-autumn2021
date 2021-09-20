package fi.haagahelia.exercises.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.exercises.Bookstore.Domain.Book;
import fi.haagahelia.exercises.Bookstore.Domain.BookRepository;
import fi.haagahelia.exercises.Bookstore.Domain.Category;
import fi.haagahelia.exercises.Bookstore.Domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class BookstoreApplication {

		
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 

	    public static void main(String[] args) {
	        SpringApplication.run(BookstoreApplication.class, args);
	    }
	    
	    @Bean
	    public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
	        return (args) -> {
	            log.info("save books");
	            log.info("save category");
	    		crepository.save(new Category("Romance"));
	    		crepository.save(new Category("Fantasy"));
	    		crepository.save(new Category("Business"));
	    		
	    		log.info("fetch all categories");
	    		for(Category category: crepository.findAll()) {
	    			log.info(category.toString());
	    		}
	    		
	            repository.save(new Book(crepository.findByName("Romance").get(0),"Ernest Hemingway", "A farewell to Arms", "1232323-21", 1929, 12.99));
	            repository.save(new Book(crepository.findByName("Fantasy").get(0),"George Orwell", "Animal Farm", "22122343-5", 1945, 9.99));    
	            repository.save(new Book(crepository.findByName("Business").get(0),"Geoffrey Cain", "Samsung rising", "978-0-75355-481-4", 2020, 14.99)); 
	            
	            log.info("fetch all books");
	            for (Book book : repository.findAll()) {
	                log.info(book.toString());
	            }
	 
	        };
	    }

	    } 
	
