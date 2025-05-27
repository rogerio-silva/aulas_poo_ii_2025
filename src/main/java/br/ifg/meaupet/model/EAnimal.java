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
@Table (name = "animais")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EAnimal {
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
    @Size(min = 4, max = 20)
    private String especie;
    @NotBlank
    private boolean adotado;
}
