package fi.haagahelia.exercises.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.exercises.Bookstore.Domain.Book;
import fi.haagahelia.exercises.Bookstore.Domain.BookRepository;
import fi.haagahelia.exercises.Bookstore.Domain.Category;
import fi.haagahelia.exercises.Bookstore.Domain.CategoryRepository;
import fi.haagahelia.exercises.Bookstore.Domain.UserRepository;
import fi.haagahelia.exercises.Bookstore.Domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class BookstoreApplication extends SpringBootServletInitializer {
		
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder
				application) {
			return  application.sources(BookstoreApplication.class);
		}
		
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); 

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(BookstoreApplication.class, args);
	    }
	    
	    @Bean
	    public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
	        return (args) -> {
	            log.info("save books!!");
	            log.info("save category");
	    		crepository.save(new Category("Romance"));
	    		crepository.save(new Category("Fantasy"));
	    		crepository.save(new Category("Business"));
	    		crepository.save(new Category("Thriller"));
	    		
	    		log.info("fetch all categories");
	    		for(Category category: crepository.findAll()) {
	    			log.info(category.toString());
	    		}
	    		
	            repository.save(new Book(crepository.findByName("Romance").get(0),"Ernest Hemingway", "A farewell to Arms", "1232323-21", 1929, 12.99));
	            repository.save(new Book(crepository.findByName("Fantasy").get(0),"George Orwell", "Animal Farm", "22122343-5", 1945, 9.99));    
	            repository.save(new Book(crepository.findByName("Business").get(0),"Geoffrey Cain", "Samsung rising", "978-0-75355-481-4", 2020, 14.99)); 
	            repository.save(new Book(crepository.findById(Long.valueOf(4)).get(), "Test delete", "Test delete", "Test delete", 2020, 50.9));
	            
	            log.info("fetch all books");
	            for (Book book : repository.findAll()) {
	                log.info(book.toString());
	            }
	            
	            log.info("save users");
	            User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user.example@gmail.com");
	            User user2 = new User("admin", "$2a$10$e8AjiBnDUtURW/GtFc8VGerrY1p0tDYI2eP/NIPSh3.fE4rbRBh3C","ADMIN", "admin.example@gmail.com");
	            urepository.save(user1);
	            urepository.save(user2);
	        };
	    }}