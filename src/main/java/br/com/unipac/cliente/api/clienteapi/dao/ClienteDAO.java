package br.com.unipac.cliente.api.clienteapi.dao;

import java.util.List;

import br.com.unipac.cliente.api.clienteapi.domain.Cliente;

public interface ClienteDAO {
	
	boolean salvar(Cliente cliente);
	
	boolean alterar(Long id, Cliente cliente);
	
	List<Cliente> listarTodos();
	
	boolean buscarPorId(Cliente cliente);
	
	boolean removerPorId(Cliente cliente);
	
}
