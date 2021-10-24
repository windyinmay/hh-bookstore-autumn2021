package fi.haagahelia.exercises.Bookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


import fi.haagahelia.exercises.Bookstore.web.BookController;
import fi.haagahelia.exercises.Bookstore.web.BookRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	@Autowired
	private BookRestController bookRestController;

	@Test
	public void contextLoads() throws Exception {
		   assertThat(bookController).isNotNull();
		   assertThat(bookRestController).isNotNull();
		   
	}

}
