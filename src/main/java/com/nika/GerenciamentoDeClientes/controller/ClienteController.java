package com.nika.GerenciamentoDeClientes.controller;

import com.nika.GerenciamentoDeClientes.model.ClienteModel;
import com.nika.GerenciamentoDeClientes.service.ClienteService;
import org.apache.catalina.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    //201
    @PostMapping
    public ResponseEntity<ClienteModel> criar(@RequestBody ClienteModel cliente){
        ClienteModel salvo = service.criar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping
    public ResponseEntity<ClienteModel> atualizar(@PathVariable Long id, @RequestBody ClienteModel clienteAtualizado){
        try{
            ClienteModel cliente = service.atualizar(id, clienteAtualizado);
            return ResponseEntity.ok(cliente);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> listar(){
        List<ClienteModel> cliente = service.listar();
        return ResponseEntity.ok(cliente);
    }

    //200 or 404
    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> buscar(@PathVariable Long id){
        try{
            ClienteModel cliente = service.buscar(id);
            return ResponseEntity.ok(cliente);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


    //204 or 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        try{
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }


}
