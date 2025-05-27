package br.ifg.meaupet.repository;

import br.ifg.meaupet.model.EAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository <EAnimal, Long> {

}
