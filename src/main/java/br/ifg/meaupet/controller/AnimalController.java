package br.ifg.meaupet.controller;

import br.ifg.meaupet.dto.AnimalDTO;
import br.ifg.meaupet.services.AnimalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping
    public Page<AnimalDTO> listarAnimais(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterAnimais(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> detalharAnimal(@PathVariable @NotNull Long id) {
        AnimalDTO dto = service.obterAnimalPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> cadastrarAnimal(@RequestBody @Valid AnimalDTO dto, UriComponentsBuilder uriBuilder) {
        AnimalDTO pessoa = service.cadastrarAnimal(dto);
        URI uri = uriBuilder.path("/animais/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalDTO> atualizarAnimal(@PathVariable @NotNull Long id, @RequestBody AnimalDTO dto, UriComponentsBuilder uriBuilder) {
        AnimalDTO pessoa = service.atualizarAnimal(id, dto);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAnimal(@PathVariable @NotNull Long id) {
        service.deletarAnimal(id);
        return ResponseEntity.noContent().build();
    }

//    @PostMapping
//    public ResponseEntity<AnimalDTO> adotarAnimal(@RequestBody @Valid AnimalDTO dto, UriComponentsBuilder uriBuilder) {
////        AnimalDTO  = service.adotarAnimal(dto);
////        URI uri = uriBuilder.path("/animais/{id}").buildAndExpand(pessoa.getId()).toUri();
////        return ResponseEntity.created(uri).body(pessoa);
//    }
}
