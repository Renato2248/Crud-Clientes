package com.br.senai.apicrud.cliente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record DadosCadastroCliente(
        @NotBlank
        @Size(min = 3, max = 100)
        String nome,

        @NotBlank
        @Size(max = 255)
        @Column(unique = true)
        @Email
        String email,

        @NotBlank
        @Size(min = 11, max = 11)
        @Column(unique = true)
        @CPF
        String cpf,

        @Size(max = 20)
        @Pattern(regexp = "\\d{10,11}")
        String telefone
) {

}
