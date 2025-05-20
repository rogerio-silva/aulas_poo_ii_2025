package br.ifg.meaupet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Positive
    private int idade;
    @NotBlank
    @Size(min = 4, max = 50)
    private String nome;
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;
    @NotBlank
    @Size(min = 8, max = 15)
    private String telefone;
    @NotBlank
    @Size(min = 8, max = 50)
    private String email;
}
