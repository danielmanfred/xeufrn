package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.ConnectionFactory;

public class DemandaDAO {

	public void salvar(Integer solicitador, Integer item) {
		
                Connection c = ConnectionFactory.getConnection();
                PreparedStatement ps = null;
            
		String sql = "INSERT INTO demanda (solicitador, item_id) VALUES (?,?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setInt(1, solicitador);
			statement.setInt(2, item);
			statement.executeUpdate();
			System.out.println("Demanda realizada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na realiza��o da demanda");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
	
	public void listarDemandasUsuario(Integer solicitador) {
            
	}
}
