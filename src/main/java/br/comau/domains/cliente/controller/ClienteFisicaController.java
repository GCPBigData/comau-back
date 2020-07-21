package br.comau.domains.cliente.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.comau.domains.cliente.dto.ClienteFisicaDTO;
import br.comau.domains.cliente.model.ClienteFisica;
import br.comau.domains.cliente.service.AlteraClienteFisicaService;
import br.comau.domains.cliente.service.ConsultaClienteFisicaService;
import br.comau.domains.cliente.service.RemoveClienteFisicaService;
import br.comau.domains.cliente.service.SalvaClienteFisicaService;
import br.comau.exception.ResourceNotFoundException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "clientefisica")
public class ClienteFisicaController {

    @Autowired
    private ConsultaClienteFisicaService consultaClienteFisicaService;
    
    @Autowired
    private SalvaClienteFisicaService salvaClienteFisicaService;
    
    @Autowired
    private AlteraClienteFisicaService alteraClienteFisicaService;
    
    @Autowired
    private RemoveClienteFisicaService removeClienteFisicaService;
    
    @GetMapping()
    public List<ClienteFisica> getAllClienteFisica() {
        return this.consultaClienteFisicaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFisica> getClienteFisicaById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return ResponseEntity.ok().body(this.consultaClienteFisicaService.getById(id));
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/listaFiltro", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteFisicaDTO>> findAll(){
        List<ClienteFisicaDTO> listDto = this.consultaClienteFisicaService.getAllFilter();
        HttpStatus status = listDto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(listDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/listaFiltroAtivo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteFisicaDTO>> findAllAtivo(){
        List<ClienteFisicaDTO> listDto = this.consultaClienteFisicaService.getAllFilterAtivo();
        HttpStatus status = listDto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(listDto);
    }

    @PostMapping()
    public ClienteFisica createClienteFisica(@RequestBody ClienteFisica clienteFisica) {
        return this.salvaClienteFisicaService.saveClienteFisica(clienteFisica);
    }

    @PutMapping()
    public ResponseEntity<ClienteFisica> updateClienteFisica(
            @RequestBody ClienteFisica clienteFisica) throws ResourceNotFoundException {
        return ResponseEntity.ok(this.alteraClienteFisicaService.updateClienteFisica(clienteFisica));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteClienteFisica(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return this.removeClienteFisicaService.deleteClienteFisica(id);
    }
    
    
    /*
     *    https://www.baeldung.com/queries-in-spring-data-mongodb
     *    https://www.journaldev.com/18156/spring-boot-mongodb
     */
    @GetMapping("/listaFiltroFull/{criteria}")
    public List<ClienteFisica> getAllClienteCriteria(@PathVariable(value = "criteria") String crit) {
        return this.consultaClienteFisicaService.getAllClienteCriteria(crit);
    }

}