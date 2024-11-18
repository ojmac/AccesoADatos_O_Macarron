package manejoDeConectores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio11_1 {

	public void listaTareas(int[] ids, int finalizada) {

		String url = "jdbc:mysql://localhost:3306/tareas_pendientes";
		Connection con = null;
		CallableStatement cstm = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(url, "root", "");

			for (int id : ids) {
				//String strSQL = "{call actualizaYMuestraTareas("+ id + "," + finalizada + " )}";
				//cstm = con.prepareCall(strSQL);
				String strSQL = "{call actualizaYMuestraTareas(?,?)}";
				cstm = con.prepareCall(strSQL);
			     cstm.setInt(1, id);           
		         cstm.setInt(2, finalizada);
				rs = cstm.executeQuery();

				while (rs.next()) {
					int idC = rs.getInt("id");
					String descC = rs.getString("descripcion");
					boolean finalizadaC = rs.getBoolean("finalizada");
					
					System.out.printf("La tarea cambiada, con id = %d cuya  descripción es:  %s" + System.lineSeparator(), idC, descC);
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if(cstm!=null && !cstm.isClosed()) {
					cstm.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				try {
					if(con!=null && !con.isClosed()) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
		}

	}

}
