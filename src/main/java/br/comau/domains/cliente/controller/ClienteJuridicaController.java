package br.comau.domains.cliente.controller;

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

import br.comau.domains.cliente.model.ClienteJuridica;
import br.comau.domains.cliente.service.AlteraClienteJuridicaService;
import br.comau.domains.cliente.service.ConsultaClienteJuridicaService;
import br.comau.domains.cliente.service.RemoveClienteJuridicaService;
import br.comau.domains.cliente.service.SalvaClienteJuridicaService;
import br.comau.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "clientejuridica")
public class ClienteJuridicaController {

	@Autowired
	private ConsultaClienteJuridicaService consultaClienteJuridicaService;
	
	@Autowired
	private SalvaClienteJuridicaService salvaClienteJuridicaService;
	
	@Autowired
	private AlteraClienteJuridicaService alteraClienteJuridicaService;
	
	@Autowired
	private RemoveClienteJuridicaService removeClienteJuridicaService;
    

    @GetMapping()
    public List<ClienteJuridica> getAllClienteJuridica() {
        return this.consultaClienteJuridicaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteJuridica> getClienteJuridicaById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return ResponseEntity.ok().body(this.consultaClienteJuridicaService.getById(id));
    }

    @PostMapping()
    public ClienteJuridica createCleinteJuridica(@RequestBody ClienteJuridica clienteJuridica) {
        return this.salvaClienteJuridicaService.saveClienteJuridica(clienteJuridica);
    }

    @PutMapping()
    public ResponseEntity<ClienteJuridica> updateClienteJuridica(
            @RequestBody ClienteJuridica clienteJuridica) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.alteraClienteJuridicaService.updateClienteJuridica(clienteJuridica));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteClienteJuridica(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return this.removeClienteJuridicaService.deleteClienteJuridica(id);
    }
}