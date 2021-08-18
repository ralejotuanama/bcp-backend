package com.bcp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcp.exception.ModeloNotFoundException;
import com.bcp.model.Tipocambio;
import com.bcp.service.ITipocambioService;

@RestController
@RequestMapping("/tipocambio")

public class TipoCambioController {

	@Autowired
	private ITipocambioService service;

	@GetMapping
	public ResponseEntity<List<Tipocambio>> listar() throws Exception {
		List<Tipocambio> lista = service.listar();
		return new ResponseEntity<List<Tipocambio>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tipocambio> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Tipocambio obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Tipocambio>(obj, HttpStatus.OK);
	}

	@GetMapping("/hateoas/{id}")
	public EntityModel<Tipocambio> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception {
		Tipocambio obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}

		EntityModel<Tipocambio> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));

		recurso.add(linkTo.withRel("tipocambio-recurso"));

		return recurso;
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Tipocambio tipocambio) throws Exception {
		Tipocambio obj = service.registrar(tipocambio);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdTipocambio()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Tipocambio> modificar(@Valid @RequestBody Tipocambio tipocambio) throws Exception {
		Tipocambio obj = service.modificar(tipocambio);
		return new ResponseEntity<Tipocambio>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Tipocambio obj = service.listarPorId(id);
		if (obj.getIdTipocambio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
