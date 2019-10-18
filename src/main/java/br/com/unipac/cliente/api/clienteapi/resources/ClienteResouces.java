package br.com.unipac.cliente.api.clienteapi.resources;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unipac.cliente.api.clienteapi.dao.ClienteDAO;
import br.com.unipac.cliente.api.clienteapi.domain.Cliente;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteResouces {
	@Autowired
	private ClienteDAO dao;
	
	@RequestMapping(method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
			@ResponseBody
			public ResponseEntity<List<Cliente>> listaTodos() {
			List<Cliente> clientes = dao.listarTodos();
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
			}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
			@ResponseBody
			public ResponseEntity<Boolean> salvar(@RequestBody Cliente cliente) {
			boolean resultado = dao.salvar(cliente);
			return new ResponseEntity<Boolean>(resultado, HttpStatus.CREATED);
			}
	
	@RequestMapping(path="/{id}", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
			@ResponseBody
			public ResponseEntity<Boolean> alterar(@PathParam(value = "id") Long id,
			@RequestBody Cliente cliente) {
			boolean resultado = dao.alterar(id, cliente);
			return new ResponseEntity<Boolean>(resultado, HttpStatus.OK);
			}
			@RequestMapping(path="/{id}", method = RequestMethod.DELETE,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
			@ResponseBody
			public ResponseEntity<Boolean> deletar(@PathParam(value = "id") Long id, @RequestBody Cliente cliente) {
			boolean resultado = dao.removerPorId(cliente);
			return new ResponseEntity<Boolean>(resultado, HttpStatus.OK);
			}
}
