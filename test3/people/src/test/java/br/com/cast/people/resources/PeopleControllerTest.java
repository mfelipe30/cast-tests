package br.com.cast.people.resources;

import static br.com.cast.people.TestHelper.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import br.com.cast.people.domain.People;
import br.com.cast.people.repository.PeopleRepository;
import br.com.cast.people.controller.PeopleController;

public class PeopleControllerTest extends AbstractControllerTest {

	private MockMvc mockMvc;

	private final String BASE_URL = "/peoples";

	@Mock
	private PeopleRepository repository;

	@InjectMocks
	private PeopleController controller;

	@Before
	public void init() {
		// initialize the mocks before test starts
		MockitoAnnotations.initMocks(this);
		this.mockMvc = standaloneSetup(controller).setHandlerExceptionResolvers(createExceptionResolver()) // set the
																											// same
																											// exceptionResolver
																											// of the
																											// application
				.build();
	}

	/**
	 * Find a people by Id
	 * 
	 * @throws Exception
	 */
	@Test
	public void findById() throws Exception {
		// creates the constants to populate the entity and test the return later
		final long id = 1L;
		final String name = "Matheus";
		final String street = "Manoel Corte Real";
		final Integer number = 289;
		final String city = "Recife";
		final String state = "Pernambuco";

		final People people = new People();
		extracted(people).setId(id);
		extracted(people).setName(name);
		extracted(people).setStreet(street);
		extracted(people).setNumber(number);
		extracted(people).setCity(city);
		extracted(people).setState(state);

		when(repository.findById(id)).thenReturn(extracted(people));
		this.mockMvc.perform(get(BASE_URL + "/{id}", id).accept(APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(new Long(id).intValue()))).andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.street", is(street))).andExpect(jsonPath("$.number", is(number)))
				.andExpect(jsonPath("$.city", is(city))).andExpect(jsonPath("$.state", is(state)));
	}

	private People extracted(final People people) {
		return people;
	}

	/**
	 * Try to find a people that does not exist
	 * 
	 * @throws Exception
	 */
	@Test
	public void findByIdNotFound() throws Exception {
		final long id = 1L;
		when(repository.findById(id)).thenReturn(null);
		this.mockMvc.perform(get(BASE_URL + "/{id}", id).accept(APPLICATION_JSON_UTF8))
				.andExpect(status().isNotFound());
	}

	/**
	 * Test car insert
	 * 
	 * @throws Exception
	 */
	@Test
	public void insertPeople() throws Exception {
		// creates the constants to populate the entity
		final long id = 1L;
		final String name = "Mathues";
		final String street = "Manoel Corte Real";
		final Integer number = 289;
		final String city = "Recife";
		final String state = "Pernambuco";

		final People people = new People();
		extracted(people).setId(id);
		extracted(people).setName(name);
		extracted(people).setStreet(street);
		extracted(people).setNumber(number);
		extracted(people).setCity(city);
		extracted(people).setState(state);

		this.mockMvc.perform(
				post(BASE_URL).contentType(APPLICATION_JSON_UTF8).content(convertObjectToJsonBytes(extracted(people))))
				.andExpect(status().isOk());
		verify(repository, times(1)).saveAndFlush(any());

	}

	/**
	 * Test people insert with null brand and model
	 * 
	 * @throws Exception
	 */
	@Test
	public void insertPeopleNullValues() throws Exception {
		// creates the constants to populate the entity
		final long id = 1L;
		final String name = "Matheus Moreira";
		// creates a car entity
		final People people = new People();
		extracted(people).setId(id);
		extracted(people).setName(name);

		this.mockMvc.perform(
				post(BASE_URL).contentType(APPLICATION_JSON_UTF8).content(convertObjectToJsonBytes(extracted(people)))
					)
				.andExpect(status().isBadRequest());
			
	}
	
	
	
	
}
