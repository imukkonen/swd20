package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.swd20.Bookstore.web.BookController;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Autowired
    private BookController controller;

    @Test //yksi testimetodi, jos sovelluksen käynnistyessä alusta luo controlleriolion (ei ole null)
    //
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }	

}

