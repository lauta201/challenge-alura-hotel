package com.hotel.jdbc.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;



import com.hotel.jdbc.dao.UsuarioDao;

import com.hotel.jdbc.model.Usuario;

public class UsuarioController {
	private UsuarioDao usuarioDao;

	public UsuarioController() throws SQLException {
		
		this.usuarioDao = new UsuarioDao();
		
	}
	public void guardar(Usuario usuario) throws SQLException {
		usuarioDao.guardar(usuario);
		
	}

	public List<Usuario> buscarId(String id)  throws SQLException{
		return this.usuarioDao.buscarId(id);
	}
	
	public List<Usuario> buscarUsuarios() throws SQLException{
		return this.usuarioDao.buscarUsuarios();
	}
	
	public void actualizarHuesped(String nombre, String apellido,Date fechaNacimiento, String telefono, String nacionalidad, Integer idReserva, int id) {
		usuarioDao.actualizarHuesped(nombre, apellido, fechaNacimiento, telefono, nacionalidad, idReserva, id);
	}
	
	
	public void eliminar(String id) {
		this.usuarioDao.eliminar(id);
	}
	
	
}
