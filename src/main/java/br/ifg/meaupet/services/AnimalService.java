package br.ifg.meaupet.services;

import br.ifg.meaupet.dto.AnimalDTO;
import br.ifg.meaupet.model.EAnimal;
import br.ifg.meaupet.repository.AnimalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    @Autowired
    AnimalRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Page<AnimalDTO> obterAnimais(Pageable paginacao) {
        return repository.findAll(paginacao).map(entidade -> modelMapper.map(entidade, AnimalDTO.class));
    }

    public AnimalDTO obterAnimalPorId(Long id) {
        EAnimal entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(entidade, AnimalDTO.class);
    }

    public AnimalDTO cadastrarAnimal(AnimalDTO dto) {
        EAnimal entidade = modelMapper.map(dto, EAnimal.class);
        repository.save(entidade);
        return modelMapper.map(entidade, AnimalDTO.class);
    }

    public void deletarAnimal(Long id) {
        EAnimal entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        repository.delete(entidade);
    }

    //Rever com o Ciro caso erro
    public AnimalDTO atualizarAnimal(Long id, AnimalDTO dto) {
        EAnimal entidade = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        modelMapper.map(dto, entidade);
        repository.save(entidade);
        return modelMapper.map(entidade, AnimalDTO.class);
    }

    public void adotarAnimal(AnimalDTO dto) {

    }
}
