package br.ifg.meaupet.services;

import br.ifg.meaupet.repository.PessoaRepository;

public class PessoaService {
    private final PessoaRepository pessoaRepository;
    public PessoaService(PessoaRepository repository) {
        this.pessoaRepository = repository;
    }
}
