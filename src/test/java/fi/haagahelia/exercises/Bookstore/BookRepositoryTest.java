package fi.haagahelia.exercises.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.exercises.Bookstore.Domain.Book;
import fi.haagahelia.exercises.Bookstore.Domain.BookRepository;
import fi.haagahelia.exercises.Bookstore.Domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = bookrepository.findAllByTitle("Animal Farm");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("George Orwell");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book(crepository.findByName("Reality").get(0), "Anh Pham", "How to forget M", "221030059396", 2021, 100000);
		bookrepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		long deletedRecords = bookrepository.deleteByTitle("Test delete");
		assertThat(deletedRecords).isEqualTo(1);
	}
}
