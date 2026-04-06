package com.nika.GerenciamentoDeClientes.repositories;

import com.nika.GerenciamentoDeClientes.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
