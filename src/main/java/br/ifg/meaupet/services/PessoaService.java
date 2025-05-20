package br.ifg.meaupet.services;

import br.ifg.meaupet.dto.PessoaDTO;
import br.ifg.meaupet.model.EPessoa;
import br.ifg.meaupet.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<PessoaDTO> obterPessoas(Pageable paginacao) {
        return repository.findAll(paginacao).map(entidade -> modelMapper.map(entidade, PessoaDTO.class));
    }

    public PessoaDTO obterPessoaPorId(Long id) {
        EPessoa entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(entidade, PessoaDTO.class);
    }

    public PessoaDTO cadastrarPessoa(PessoaDTO dto) {
        EPessoa entidade = modelMapper.map(dto, EPessoa.class);
        repository.save(entidade);
        return modelMapper.map(entidade, PessoaDTO.class);
    }

    public void deletarPessoa(Long id) {
        EPessoa entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        repository.delete(entidade);
    }

    //Rever com o Ciro caso erro
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO dto) {
        EPessoa entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        modelMapper.map(dto, entidade);
        repository.save(entidade);
        return modelMapper.map(entidade, PessoaDTO.class);
    }
}
