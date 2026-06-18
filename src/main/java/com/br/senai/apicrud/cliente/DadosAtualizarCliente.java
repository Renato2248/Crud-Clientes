package com.br.senai.apicrud.cliente;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizarCliente(     Long id,

                                         @Size(min = 3, max = 100)
                                         String nome,

                                         @Size(max = 255)
                                         @Column(unique = true)
                                         String email,

                                         @Size(max = 20)
                                         @Pattern(regexp = "\\d{10,11}")
                                         String telefone
                                    ) {
}
