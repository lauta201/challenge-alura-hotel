package com.hotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;



import com.hotel.jdbc.connection.ConexionBaseDatos;
import com.hotel.jdbc.model.Reserva;





public class ReservaDao {
	private Connection getConexion() throws SQLException {
		return ConexionBaseDatos.getConnection();
	}
	
	
	
	//Hacer metodo Buscar;


	
	
	
	// Guardar
	public void guardar(Reserva reserva) throws SQLException  {
		String  sql = "INSERT INTO reserva (fecha_entrada, fecha_salida, valor, forma_pago) VALUES(?,?, ?, ?)";
		 
		 try(PreparedStatement stm = getConexion().prepareStatement(sql)) {
			
			 	
			 stm.setDate(1,reserva.getFechaEntrada());
			 stm.setDate(2, reserva.getFechaSalida());
			 stm.setString(3, reserva.getValorReserva());	
			 stm.setString(4,reserva.getFormaPago());
			 stm.execute();
			 System.out.println(" sql");
			 stm.close();
			 getConexion().close();
			
			 }catch (SQLException e) {
				 
			 System.out.println("no Se ejecuto sql");
		 		throw new RuntimeException();
		 }
	 }
	
	//buscar 
	
	public  List<Reserva> buscar() {
	    List<Reserva> resultado = new ArrayList<>();

	    try {
	    	
	    	
			
	        String sql = "SELECT id_reserva, fecha_entrada, fecha_salida, valor, forma_pago "
	        + " FROM reserva ";
	        System.out.println(sql);
	        
	        try ( PreparedStatement stm = getConexion().prepareStatement(sql);) {
	            
	            stm.executeQuery();

	            transformarResultSetEnReserva(resultado,stm);
	            
	        }
	        
	      
	    } catch (SQLException e) {
	        throw new RuntimeException(e);
	    }
	    
	    return resultado;

	}
	
	
	
	
	
	public List<Reserva> buscarId (String id){
		List<Reserva> resultado = new ArrayList<>();

	    try {
	    	
	    	
			
	        String sql = "SELECT id_reserva, fecha_entrada, fecha_salida, valor, forma_pago "
	        + " FROM reserva WHERE id_reserva = ? ";
	        
	        PreparedStatement stm = getConexion().prepareStatement(sql);
	        stm.setString(1, id);
	        
	        stm.execute();
	        
	        transformarResultSetEnReserva(resultado, stm);
	        
	        
	    }catch(SQLException e) {

	    	throw new RuntimeException();
	    }
	    
	    return resultado;
	
	}	
	
	
	private static void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Reserva reserva = new Reserva(rst.getInt(1), rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5));

				reservas.add(reserva);
			}
		}
	}
	
	
	
	public void editar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
		try (PreparedStatement stm = getConexion()
				.prepareStatement("UPDATE reserva SET fecha_entrada = ?, fecha_salida = ?, valor = ?, forma_pago = ? WHERE id_reserva = ?")) {
			stm.setDate(1, fechaE);
			stm.setDate(2, fechaS);
			stm.setString(3, valor);
			stm.setString(4, formaPago);
			stm.setInt(5, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	public void eliminar(String id) {

		try {

			PreparedStatement stm = getConexion().prepareStatement("DELETE FROM reserva WHERE id_reserva = ?");
			
					stm.setString(1, id);
			stm.execute();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
