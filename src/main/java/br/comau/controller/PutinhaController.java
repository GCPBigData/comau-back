package br.comau.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.comau.exception.ResourceNotFoundException;
import br.comau.model.Putinhas;
import br.comau.repository.PutinhaRepository;
import br.comau.service.SequenceGeneratorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PutinhaController {
	@Autowired
	private PutinhaRepository putinhaRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;

	@GetMapping("/putas")
	public List<Putinhas> getAllEmployees() {
		return putinhaRepository.findAll();
	}

	@GetMapping("/putas/{id}")
	public ResponseEntity<Putinhas> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Putinhas putinhas = putinhaRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DA PUTA" + employeeId));
		return ResponseEntity.ok().body(putinhas);
	}

		@PostMapping("/putas/post")
	public Putinhas createEmployee(@RequestBody Putinhas putinhas) {
		putinhas.setId(sequenceGeneratorService.generateSequence(Putinhas.SEQUENCE_NAME));
		return putinhaRepository.save(putinhas);
	}

	@PutMapping("/putas/{id}")
	public ResponseEntity<Putinhas> updateEmployee(@PathVariable(value = "id") Long employeeId,
												   @RequestBody Putinhas putinhasDetails) throws ResourceNotFoundException {
		Putinhas putinhas = putinhaRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI A PUTA :: " + employeeId));

		putinhas.setEmail(putinhasDetails.getEmail());
		putinhas.setNome(putinhasDetails.getNome());
		putinhas.setNomeGuerra(putinhasDetails.getNomeGuerra());
		final Putinhas updatedPutinhas = putinhaRepository.save(putinhas);
		return ResponseEntity.ok(updatedPutinhas);
	}

	@DeleteMapping("/putas/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Putinhas putinhas = putinhaRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("ID PUTA " + employeeId));

		putinhaRepository.delete(putinhas);
		Map<String, Boolean> response = new HashMap<>();
		response.put("MATOU PUTA", Boolean.TRUE);
		return response;
	}
}
