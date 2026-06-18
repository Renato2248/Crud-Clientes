package com.br.senai.apicrud.cliente;

public record DadosDetalhesCliente(String nome, String email, String cpf, String telefone) {


    public DadosDetalhesCliente(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getTelefone());

    }
}