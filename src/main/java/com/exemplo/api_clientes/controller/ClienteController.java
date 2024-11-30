package com.exemplo.api_clientes.controller;

import com.exemplo.api_clientes.model.Cliente;
import com.exemplo.api_clientes.repository.ClienteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Indica que esta classe é um controlador REST
@RestController
// Mapeia as requisições que começam com '/clientes' para esta classe
@RequestMapping("/clientes")
public class ClienteController {

    // Injeta o repositório de clientes via construtor
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteRepository.findById(id).map(clienteAtualizado -> {
            clienteAtualizado.setNome(cliente.getNome());
            return clienteRepository.save(clienteAtualizado);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteRepository.deleteById(id);
    }
}
