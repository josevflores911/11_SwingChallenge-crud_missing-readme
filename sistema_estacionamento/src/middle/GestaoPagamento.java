package middle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Vehiculo;
import conectorBD.Conexion;

public class GestaoPagamento {

	public Vehiculo ObterVehiculo(int clienteSalida) {
		Vehiculo vehiculo = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.getConexion();
			
			String sql ="select * from tbl_movimentacao where id=?";
			pst = con.prepareStatement(sql);
			
			pst.setLong(1, clienteSalida);
			
			
			rs=pst.executeQuery();
			
			
			while(rs.next()) {
				vehiculo = new Vehiculo(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				
				//System.out.println(rs.getString(5)+"gestaPagament0");
			}
			
		}catch(Exception e) {
			
			System.out.println("erro ao obter vehiculo");
			
		}
		
		
		
		return vehiculo;
		
		
	}
}
