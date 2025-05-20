package br.ifg.meaupet.controller;

import br.ifg.meaupet.dto.PessoaDTO;
import br.ifg.meaupet.services.PessoaService;
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
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public Page<PessoaDTO> listarPessoas(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterPessoas(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> detalharPessoa(@PathVariable @NotNull Long id) {
        PessoaDTO dto = service.obterPessoaPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody @Valid PessoaDTO dto, UriComponentsBuilder uriBuilder) {
        PessoaDTO pessoa = service.cadastrarPessoa(dto);
        URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> atualizarPessoa(@PathVariable @NotNull Long id, @RequestBody PessoaDTO dto, UriComponentsBuilder uriBuilder) {
        PessoaDTO pessoa = service.atualizarPessoa(id, dto);
        return ResponseEntity.ok(pessoa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable @NotNull Long id) {
        service.deletarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
