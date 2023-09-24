package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.connection.ConexionBaseDatos;

import com.hotel.jdbc.model.Usuario;



public class UsuarioDao {
	private Connection getConexion() throws SQLException {
		return ConexionBaseDatos.getConnection();
	}

	// Guardar
	public void guardar(Usuario usuario)  {
		String sql = "INSERT INTO huesped (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva)VALUES(?, ?, ?, ?, ?, ?)";
		 try( PreparedStatement stm = getConexion().prepareStatement(sql)){
			
				 stm.setString(1,usuario.getNombre());
				 stm.setString(2, usuario.getApellido());
				 stm.setDate(3, usuario.getFechaNacimiento());
				 stm.setString(4, usuario.getNAcionalidad());
				 stm.setString(5, usuario.getTelefono());
				 stm.setInt(6, usuario.getIdReserva());
				 System.out.println(" sql");

				 stm.execute();
				 stm.close();
				 getConexion().close();
				 
		 	}catch (SQLException e) {
		 		
		 		System.out.println("No se ejecuto sql");
		 		throw new RuntimeException();
		 	}
		 
	}
	
	
	public List<Usuario> buscarUsuarios (){
		List<Usuario> resultado = new ArrayList<>();

	    try {


	        String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva FROM huesped";
	        
	        PreparedStatement stm = getConexion().prepareStatement(sql);
	        stm.executeQuery();
	        
	        transformarResultSetEnUsuario(resultado, stm);
	        
	    }catch(SQLException e) {

	    	throw new RuntimeException();
	    }
	    
	    return resultado;
	}	
	
	
	public List<Usuario> buscarId (String id){
		List<Usuario> resultado = new ArrayList<>();

	    try {
	    	
	    	

	        String sql = "SELECT id, nombre, apellido, fecha_nacimiento, nacionalidad, telefono, id_reserva "
	        + " FROM huesped WHERE id = ? ";
	        System.out.println(sql);
	        
	        PreparedStatement stm = getConexion().prepareStatement(sql);
	        stm.setString(1, id);
	        
	        stm.execute();
	        
	        transformarResultSetEnUsuario(resultado, stm);
	        
	    }catch(SQLException e) {

	    	throw new RuntimeException();
	    }
	    
	    return resultado;
	}	
	
	
	private static void transformarResultSetEnUsuario(List<Usuario> usuarios, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Usuario usuario = new Usuario(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDate(4),rst.getString(5),rst.getString(6),rst.getInt(7));
				usuarios.add(usuario);
			}
		}
	
	
	}

	
	
	
	public void actualizarHuesped(String nombre, String apellido,Date fechaNacimiento, String telefono, String nacionalidad, Integer idReserva, int id ) {
		 
		String sql = "UPDATE huesped SET  nombre=?, apellido=?, fecha_nacimiento=?, nacionalidad=?, telefono=?, id_reserva=? WHERE id=?";
		
		try {
			
			
			PreparedStatement stm = getConexion().prepareStatement(sql);
			stm.setString(1, nombre);
			stm.setString(2, apellido);
			stm.setDate(3, fechaNacimiento);
			stm.setString(4, telefono);
			stm.setString(5, nacionalidad);
			stm.setInt(6, idReserva);
			stm.setInt(7,id);			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void eliminar(String id) {
		
		try {
			
			PreparedStatement stm = getConexion().prepareStatement("DELETE FROM huesped WHERE id = ?");
			stm.setString(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
