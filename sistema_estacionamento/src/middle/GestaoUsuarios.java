package middle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conectorBD.Conexion;

import bean.Usuario;

public class GestaoUsuarios {
	
	public Usuario ObterUsuario(Usuario user) {
		Usuario usuario = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = Conexion.getConexion();
			
			String sql ="select * from tbl_usuario where usuario=? and senha=?";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, user.getUsuario());
			pst.setString(2, user.getSenha());
			
			rs=pst.executeQuery();
			
			
			while(rs.next()) {
				usuario = new Usuario(rs.getString(1),rs.getString(2),rs.getString(3));
				
				
			}
			
		}catch(Exception e) {
			System.out.println("erro ao obter user");
			
		}
		
		
		
		return usuario;
		
		
	}
	
	
	
	
	
}





















