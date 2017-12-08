package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.ConnectionFactory;

public class NegocioDAO {

	public void salvarNaoDemandada(Integer oferta) {
                
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "INSERT INTO negocio (oferta_nao_demandada) VALUES (?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setInt(1, oferta);
			statement.executeUpdate();
			System.out.println("Negocia��o realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na negocia��o");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
	
	public void salvarDemandada(Integer oferta) {
                
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "INSERT INTO negocio (oferta_demandada) VALUES (?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setInt(1, oferta);
			statement.executeUpdate();
			System.out.println("Negocia��o realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na negocia��o");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
}
