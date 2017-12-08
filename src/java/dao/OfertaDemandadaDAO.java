package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.ConnectionFactory;

public class OfertaDemandadaDAO {
	
	public void salvar(Double valor, Integer ofertante, Integer demanda) {
		
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "INSERT INTO ofertademandada (valor, ofertante, demanda_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			
			statement.setDouble(1, valor);
			statement.setInt(2, ofertante);
			statement.setInt(3, demanda);
			
			statement.executeUpdate();
			System.out.println("Oferta criada com sucesso");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println("Erro na cria��o da oferta");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}

}
