package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			log.info("save a couple of books");
			crepository.save(new Category("Kids"));
			crepository.save(new Category("Detective"));
			crepository.save(new Category("Poetry"));
			
			brepository.save(new Book("Minidinot", "Katharina Wieker", 2018, "978-952-341-071-8", 10, crepository.findByName("Kids").get(0) ));
			brepository.save(new Book("Museoseikkailu", "Elina Kuorelahti", 2019, "978-951-1-33558-0", 15, crepository.findByName("Kids").get(0)));	
			brepository.save(new Book("Sherlock Holmes : kootut kertomukset", "Arthur Conan Doyle", 2010, "978-951-851-246-5", 25, crepository.findByName("Detective").get(0)));
			
			// Create users: admin/adminadmin user/useruser
			User user1 = new User("user", "$2a$04$hFxjj6Y41fiP9RuaP5./feAR6G99wZGcNE8DuLnnGgmXFQ8QRbtxS", "user@test.fi", "USER");
			User user2 = new User("admin", "$2a$04$p/JiAezhcjGaxz.SuR48z.4rA6UmrSFWVKuyRZTefpgS7j7mx1RAq", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}

