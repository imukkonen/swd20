package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;



@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
    private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Minidinot");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Katharina Wieker");
		
	}
	
	@Test
    public void createNewBook() {
    	Book book = new Book("Mickey Mouse", "Disney", 2018, "978-952-341-011-1", 14, new Category("Comics"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    } 
	
	@Test
    public void deleteBook() {
    	Book book = new Book("Mickey Mouse", "Disney", 2018, "978-952-341-011-1", 14, new Category("Comics"));
    	repository.save(book);
    	long idb = book.getId();
    	repository.delete(book);
    	assertThat(repository.findById(idb)).isEmpty();
    } 
}
