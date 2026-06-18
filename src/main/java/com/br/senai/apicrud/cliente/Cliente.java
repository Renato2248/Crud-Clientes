package com.br.senai.apicrud.cliente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Min(value = 3)
    @Max(value = 100)
    String nome;
    @Email

    String email;
    @CPF
    String cpf;
    @Max(value = 20)
    String telefone;
    @Column()
    boolean ativo;

    public Cliente(@Valid DadosCadastroCliente dados) {
        this.nome = dados.nome();;
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.ativo = true;
    }


    public void excluirCliente() {
    }

    public void atualizarCategoria(@Valid DadosAtualizarCliente dados) {
        if(dados.nome() != null && !dados.nome().isBlank()){
            this.nome = dados.nome();
        }
        if(dados.email() != null && !dados.email().isBlank()){
            this.email = dados.email();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

    }
}
