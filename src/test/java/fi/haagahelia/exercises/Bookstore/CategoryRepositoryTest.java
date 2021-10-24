package fi.haagahelia.exercises.Bookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.exercises.Bookstore.Domain.Category;
import fi.haagahelia.exercises.Bookstore.Domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Category> cats = categoryRepository.findByName("Romance");
		assertThat(cats).hasSize(1);
	}
	
	@Test
	public void createNewCategory() {
		Category cat2 = new Category("Action");
		categoryRepository.save(cat2);
		assertThat(cat2.getCategoryId()).isNotNull();
	}
}
