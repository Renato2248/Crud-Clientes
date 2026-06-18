package com.br.senai.apicrud.controllers;


import com.br.senai.apicrud.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<DadosListagemCliente> listarClientes(){
        var lista = repository.findAllByAtivoTrue();
        return lista.stream().map(DadosListagemCliente::new).toList();
    }

    @GetMapping("/{id}")
    public DadosDetalhesCliente listarClienteEspecifico(@PathVariable Long id){
        var cliente = repository.findByIdAndAtivoTrue(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Categoria não encontrada"
        ));


        return new DadosDetalhesCliente(cliente);

    }

    @DeleteMapping("{id}")
    @Transactional
    public void deletarCliente(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirCliente();
    }

    @PostMapping
    @Transactional
    public void postarCliente(@RequestBody @Valid DadosCadastroCliente dados){
            repository.save(new Cliente(dados));
    }

    @PutMapping
    @Transactional
    public void atualizarCategoria(@RequestBody @Valid DadosAtualizarCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarCategoria(dados);
    }




}
