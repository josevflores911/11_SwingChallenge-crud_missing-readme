package middle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Ativos;
import conectorBD.Conexion;

public class VehiculosAtivos {
	
	public List<Ativos> getVehiculosAtivos(){
		List<Ativos> vehiculosAtivos = new ArrayList<>();
		
		String sql = "select * from tbl_movimentacao";
		
		try(PreparedStatement ps = Conexion.getConexion().prepareStatement(sql)){
			try(ResultSet rs = ps.executeQuery()){
				while(rs.next()) {
					Ativos ativos = new Ativos();
					ativos.setId(rs.getInt(1));
					ativos.setDescricao(rs.getString(3));
					
					vehiculosAtivos.add(ativos);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return vehiculosAtivos;
	}
	
	
	
}
