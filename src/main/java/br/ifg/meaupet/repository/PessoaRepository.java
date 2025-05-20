package br.ifg.meaupet.repository;

import br.ifg.meaupet.model.EPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <EPessoa, Long> {

}
