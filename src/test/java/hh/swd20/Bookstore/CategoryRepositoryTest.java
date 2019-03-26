package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
    private CategoryRepository repository;
	
	@Test
    public void createNewCategory() {
		
		Category cat = new Category("Fiction");
		repository.save(cat);
		assertThat(cat.getCategoryid()).isNotNull();
	}
	
	@Test
    public void deleteCategory() {
		
		Category cat = new Category("Fiction");
		repository.save(cat);
		long idc = cat.getCategoryid();
		repository.delete(cat);;
		assertThat(repository.findById(idc)).isEmpty();
	}
	
	@Test
	public void findByNameShoudReturnCategory() {
		List<Category> cats = repository.findByName("Kids");
		
		assertThat(cats).hasSize(1);
		
	}
}
