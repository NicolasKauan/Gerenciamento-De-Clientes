package com.nika.GerenciamentoDeClientes.service;

import com.nika.GerenciamentoDeClientes.model.ClienteModel;
import com.nika.GerenciamentoDeClientes.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    private ClienteModel criar(ClienteModel cliente){
        return repository.save(cliente);
    }

    private ClienteModel atualizar(Long id, ClienteModel clienteAtualizado){
        Optional<ClienteModel> clienteExistente = repository.findById(id);
        if(clienteExistente.isPresent()){
            ClienteModel cliente = clienteExistente.get();
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setStatus(clienteAtualizado.getStatus());
            cliente.setTelefone(clienteAtualizado.getTelefone());

            return repository.save(cliente);
        }else{
            throw new RuntimeException("Cliente não encontrado para o id: "+ id);
        }
    }

    private List<ClienteModel> listar(){
        return repository.findAll();
    }

    private ClienteModel buscar(long id){
        return repository.findById(id).orElse(null);
    }

    private void deletar(Long id){
        repository.deleteById(id);
    }

}
