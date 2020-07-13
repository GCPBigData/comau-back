package br.comau;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import br.comau.model.Putinhas;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PutinhasControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		Putinhas putinhas = restTemplate.getForObject(getRootUrl() + "/employees/1", Putinhas.class);
		System.out.println(putinhas.getNome());
		assertNotNull(putinhas);
	}

	@Test
	public void testCreateEmployee() {
		Putinhas putinhas = new Putinhas();
		putinhas.setEmail("admin@gmail.com");
		putinhas.setNome("Paula");
		putinhas.setNomeGuerra("Paula Biscate");

		ResponseEntity<Putinhas> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", putinhas, Putinhas.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		int id = 1;
		Putinhas putinhas = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Putinhas.class);
		putinhas.setNome("Maria");
		putinhas.setNomeGuerra("Maria Juana");

		restTemplate.put(getRootUrl() + "/employees/" + id, putinhas);

		Putinhas updatedPutinhas = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Putinhas.class);
		assertNotNull(updatedPutinhas);
	}

	@Test
	public void testDeleteEmployee() {
		int id = 2;
		Putinhas putinhas = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Putinhas.class);
		assertNotNull(putinhas);

		restTemplate.delete(getRootUrl() + "/employees/" + id);

		try {
			putinhas = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Putinhas.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
