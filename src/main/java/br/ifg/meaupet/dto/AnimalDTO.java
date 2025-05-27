package br.ifg.meaupet.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnimalDTO {
    private long id;
    private int idade;
    private String nome;
    private String especie;
    private boolean adotado;
}
