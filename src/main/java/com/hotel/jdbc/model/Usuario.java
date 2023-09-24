package com.hotel.jdbc.model;

import java.sql.Date;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;

	private String telefono;
	private Date fechaNacimiento;
	private String nacionalidad;
	private Integer IdReserva;
	
	public Usuario() {
		
	}
	public Usuario(String nombre, String apellido,Date fechaNacimiento, String nacionalidad, String telefono,Integer IdReserva ) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.IdReserva = IdReserva;
	}
	
	
	public Usuario(int id, String nombre, String apellido,Date fechaNacimiento, String telefono, String nacionalidad, Integer idReserva) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.IdReserva = idReserva;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	
	public String getContraseña() {
		return telefono;
	}
	public Integer getIdReserva() {
		return IdReserva;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public String getNAcionalidad() {
		return nacionalidad;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setContraseña(String telefono) {
		this.telefono = telefono;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	public void setIdReserva(Integer idReserva) {
		this.IdReserva = idReserva;
	}
	
	
	
	
	
}
