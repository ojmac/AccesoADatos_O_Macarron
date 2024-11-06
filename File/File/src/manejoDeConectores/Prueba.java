package manejoDeConectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Prueba {

	String url;
	String user;
	String pswd;

	public Prueba() {
		super();

	}

	public void abrirConexion(String url, String user, String pswd) {
		
		Connection conn= null;
		Statement st = null;
		ResultSet rs =null;
		ResultSet rs2 =null;
		
		try {
			conn = DriverManager.getConnection(url,user,pswd);
			st = conn.createStatement();
			rs = st.executeQuery("show create table ingrediente;");
			rs2 = st.executeQuery("select * from hamburguesa;");
			
			if (rs.next()) {  
			    String createTableSQL = rs.getString("Create Table");  
			    System.out.println(createTableSQL);  
			}
			
			while(rs.next()) {
				int id = rs2.getInt("id");
				String nombre = rs2.getString("nombre");
				
				System.out.println("El nombre es: " + nombre  + " y el id " + id);
			}
			System.out.println("conexion ok");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			if(conn !=null ) {
				try {
					if(rs!=null && !rs.isClosed())
						rs.close();
				}catch (SQLException ex){}
				try {
					if(rs2!=null && !rs2.isClosed())
						rs2.close();
				}catch (SQLException ex){}
				try {
					if(st!=null && !st.isClosed())
						st.close();
				}catch (SQLException ex){}
				try {
					conn.close();
				} 	catch (SQLException e) {}
			}
		}
	}
}
