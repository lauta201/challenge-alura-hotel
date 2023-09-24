package com.hotel.jdbc.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


import com.hotel.jdbc.dao.ReservaDao;
import com.hotel.jdbc.model.Reserva;

public class ReservaController {
private ReservaDao reservaDao;
	
	public ReservaController() throws SQLException {
		
		this.reservaDao = new ReservaDao();
		
	}

	public void guardar(Reserva reserva) {
		
		try {
			reservaDao.guardar(reserva);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void eliminar(String id) {
		reservaDao.eliminar(id);
	}
	
	public List<Reserva> buscar() {
		return this.reservaDao.buscar();
	}
	
	
	public List<Reserva> buscarId(String reserva){
		return this.reservaDao.buscarId(reserva);
	}
	
	public void editar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		reservaDao.editar(fechaE, fechaS, valor, formaPago, id);
	}

	
	
}
