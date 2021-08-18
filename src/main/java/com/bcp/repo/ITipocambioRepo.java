package com.bcp.repo;


import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bcp.model.Tipocambio;

public interface ITipocambioRepo extends IGenericRepo<Tipocambio, Integer> {
	
	
	@Query(value="select t.tipocambio from tipocambio t  where t.fecha = :fecha", nativeQuery = true)
	String RecuperarTipoCambio(@Param("fecha") LocalDate fecha);

}
