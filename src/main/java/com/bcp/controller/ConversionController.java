package com.bcp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bcp.dto.ConversionDto;
import com.bcp.exception.ModeloNotFoundException;
import com.bcp.model.Tipocambio;
import com.bcp.service.ITipocambioService;

@RestController
@RequestMapping("/conversion")

public class ConversionController {

	@Autowired
	private ITipocambioService service;

	String tipcam, smontipcam;

	@GetMapping
	public ResponseEntity<List<Tipocambio>> listar() throws Exception {
		List<Tipocambio> lista = service.listar();
		return new ResponseEntity<List<Tipocambio>>(lista, HttpStatus.OK);
	}

	@PostMapping
	public ConversionDto resultado(@RequestBody ConversionDto dto) {

		tipcam = service.RecuperarTipoCambio(LocalDate.now());
		smontipcam = String.format("%.2f", dto.getMonto() * Double.parseDouble(tipcam));

		ConversionDto conversion = new ConversionDto();
		conversion.setMonto(dto.getMonto());
		conversion.setMontocontipocambio(Double.parseDouble(smontipcam));
		conversion.setMonedaorigen(dto.getMonedaorigen());
		conversion.setMonedadestino(dto.getMonedadestino());
		conversion.setTipocambio(Double.parseDouble(tipcam));
		return conversion;

	}

}
