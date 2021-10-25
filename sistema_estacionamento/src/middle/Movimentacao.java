package middle;


import java.sql.PreparedStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import bean.Vehiculo;
import conectorBD.Conexion;

public class Movimentacao {
	
	
	public int adicionarVehiculo(Vehiculo cliente) {
		int rs = 0;
		
		//String sql ="INSERT INTO tbl_movimentacao VALUES (?,?,?,?,?,?,?)";
		String sql ="INSERT INTO tbl_movimentacao (placa, modelo, data_entrada) VALUES (?, ?, ?)";
		
		
		try (PreparedStatement ps =Conexion.getConexion().prepareStatement(sql)){
			
			//ps.setLong(1,1L);
			ps.setString(1, cliente.getPlaca());
			ps.setString(2, cliente.getModelo());
			
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss yyyy/MM/dd ");
			Date day = new Date();		
			
			
			ps.setString(3,dateFormat.format(day));
			//ps.setString(5, "null");
			//ps.setString(6, "null");
			//ps.setString(7, "null");
			
			
			
			
			rs=ps.executeUpdate();		
			
			
		}catch(Exception e) {
			System.out.println("erro ao insertar valor");	
			System.out.println("primero");
		}
				
		return rs;
	}
	
	
	public int adicionarPagamento(Vehiculo cliente,int index) {
		int rs = 0;
		
		//String sql ="INSERT INTO tbl_movimentacao VALUES (?,?,?,?,?,?,?)";
		String sql ="UPDATE tbl_movimentacao SET data_saida = ?, tempo = ?, valor_pago = ? WHERE (id = ?)";
		
		
		try (PreparedStatement ps =Conexion.getConexion().prepareStatement(sql)){
			
			//ps.setLong(1,1L);
			ps.setString(1, cliente.getSaida());
			ps.setString(2, cliente.getTempo());
			ps.setString(3, cliente.getValor());
			ps.setLong(4, index);
			
			
			
			rs=ps.executeUpdate();		
			
			
		}catch(Exception e) {
			System.out.println("erro ao insertar valor");	
			System.out.println("primero");
		}
				
		return rs;
	}
	
}
