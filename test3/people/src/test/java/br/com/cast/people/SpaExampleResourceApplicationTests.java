package br.com.cast.people;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.cast.people.service.PeopleService;;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= PeopleService.class)
public class SpaExampleResourceApplicationTests {

	@Test
	public void contextLoads() {
	}

}
