package com.bcp.service;


import java.time.LocalDate;

import com.bcp.model.Tipocambio;

public interface ITipocambioService extends ICRUD<Tipocambio, Integer> {
	
	
	String RecuperarTipoCambio(LocalDate fecha);
	

}
