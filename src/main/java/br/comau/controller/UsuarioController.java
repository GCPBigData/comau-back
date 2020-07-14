package br.comau.controller;

import br.comau.exception.ResourceNotFoundException;
import br.comau.model.Usuario;
import br.comau.repository.UsuarioRepository;
import br.comau.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Herick N Marques
 * herick.marques@gmail.com
 * Pocos de Caldas - Brazil 12/07/2020
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @GetMapping("/todos")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHOU CODIGO DO USUARIO" + id));
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/usuario/post")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        usuario.setId(sequenceGeneratorService.generateSequence(Usuario.SEQUENCE_NAME));
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable(value = "id") Long id,
            @RequestBody Usuario usuario) throws ResourceNotFoundException {

        Usuario usuarioObj = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("NAO ACHEI O USUARIO :: " + id));

        usuario.setId(usuario.getId());
        usuario.setLogin(usuario.getLogin());
        usuario.setPerfil(usuario.getPerfil());
        usuario.setPessoaFisica(usuario.getPessoaFisica());
        usuario.setPessoaJuridica(usuario.getPessoaJuridica());
        usuario.setSenha(usuario.getSenha());
        usuario.setStatus(usuario.getStatus());

        final Usuario updatedCurso = usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID Usuario " + id));

        usuarioRepository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("usuario", Boolean.TRUE);
        return response;
    }
}
