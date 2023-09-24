package com.hotel.jdbc.pruebaconexion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hotel.jdbc.connection.ConexionBaseDatos;
import com.hotel.jdbc.model.Reserva;

public class PruebaConexion {
public static void main(String[] args) throws SQLException {
		
	Reserva res = new Reserva(26);
	
	
	
	
		
}






/*public static List<Reserva> listar(long id) throws SQLException {
	
	ConexionBaseDatos factory = new ConexionBaseDatos();
	Connection con = factory.getConnection();
	Reserva reserva= null;
	List<Reserva> listaR = new ArrayList<>();
	 String sql = "SELECT id_reserva, fecha_entrada, fecha_salida, valor, forma_pago "
		        + " FROM reserva WHERE id_reserva = ?";
	try (PreparedStatement statement = con.prepareStatement(sql)){
		statement.setLong(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			reserva = new Reserva(resultSet.getLong("id_reserva") , resultSet.getDate("fecha_entrada"),
            		resultSet.getDate("fecha_salida"), resultSet.getString("valor"), resultSet.getString("forma_pago"));
			listaR.add(reserva);
            
		}
		resultSet.close();
		statement.close();
		con.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}     
	
	return listaR;
	
	
}*/


public static Reserva buscar(Reserva pro) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    ConexionBaseDatos factory = new ConexionBaseDatos();
    Connection con = factory.getConnection();

    String sql = "SELECT *  FROM reserva WHERE id_reserva = ?";

    try {
        ps = con.prepareStatement(sql);
        ps.setLong(1, pro.getId());
        rs = ps.executeQuery();

        if (rs.next()) {
        	
        	
        	
            pro.setId(null);
            pro.setFechaEntrada(rs.getDate("fecha_entrada"));
            pro.setFechaSalida(rs.getDate("fecha_salida"));
            pro.setValorReserva(rs.getString("valor"));
            pro.setFormaPago(rs.getString("forma_pago"));
            
        }
        
        System.out.println(pro);
        
    } catch (SQLException e) {
        System.err.println(e);
        
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    
    return (Reserva) rs;
    
}

















//"SELECT * FROM reserva WHERE id_reserva =: ?"

}
