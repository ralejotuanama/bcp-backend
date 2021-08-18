package com.bcp.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tipocambio")
public class Tipocambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipocambio;
	

	

	private double tipocambio;
	
	

	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;


	public Integer getIdTipocambio() {
		return idTipocambio;
	}


	public void setIdTipocambio(Integer idTipocambio) {
		this.idTipocambio = idTipocambio;
	}


	public double getTipocambio() {
		return tipocambio;
	}


	public void setTipocambio(double tipocambio) {
		this.tipocambio = tipocambio;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public void setIdTipocambio(int idTipocambio) {
		this.idTipocambio = idTipocambio;
	}


	


	

	


	
	
}
