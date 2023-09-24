package com.hotel.jdbc.model;

import java.sql.Date;

public class Reserva {
	private Integer id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private String valorReserva;
	private String formaPago;
	
	public Reserva(Date fechaEntrada, Date fechaSalida, String valorReserva, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorReserva =valorReserva;
		this.formaPago = formaPago;
	}
	
	public Reserva(Integer id) {
		this.id = id;
	}
	
	public Reserva() {
		// TODO Auto-generated constructor stub
	}
	
	public Reserva(Integer id, Date fechaEntrada, Date fechaSalida, String valorReserva, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorReserva =valorReserva;
		this.formaPago = formaPago;
	}
	
	
	
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public String getValorReserva() {
		return valorReserva;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public void setValorReserva(String valorReserva) {
		this.valorReserva = valorReserva;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
}
