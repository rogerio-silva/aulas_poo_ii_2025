package br.ifg.meaupet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDTO {
    private long id;
    private int idade;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
