package com.nika.GerenciamentoDeClientes.model;

import jakarta.persistence.*;

@Entity(name = "Clientes")
@Table(name = "tb_cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NomeCliente")
    private String nome;

    @Column(name = "EmailCliente")
    private String email;

    @Column(name = "TelefoneCliente")
    private String telefone;

    @Enumerated
    @Column(name = "StatusCliente")
    private ClienteEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public ClienteEnum getStatus() {
        return status;
    }

    public void setStatus(ClienteEnum status) {
        this.status = status;
    }
}
