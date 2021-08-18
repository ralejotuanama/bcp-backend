package com.bcp.service.impl;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcp.model.Tipocambio;
import com.bcp.repo.IGenericRepo;
import com.bcp.repo.ITipocambioRepo;
import com.bcp.service.ITipocambioService;

@Service
public class TipoCambioServiceImpl extends CRUDImpl<Tipocambio, Integer> implements ITipocambioService {

	@Autowired
	private ITipocambioRepo repo;
	
	
	@Override
	protected IGenericRepo<Tipocambio, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}


	@Override
	public String RecuperarTipoCambio(LocalDate fecha) {
		// TODO Auto-generated method stub
		return repo.RecuperarTipoCambio(fecha);
	}

}
