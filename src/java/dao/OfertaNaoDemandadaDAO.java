package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConnectionFactory;

public class OfertaNaoDemandadaDAO {
    
	
	public void salvar(Double valor, Integer ofertante, Integer item) {
            
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "INSERT INTO ofertanaodemandada (valor, ofertante, item_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			
			statement.setDouble(1, valor);
			statement.setInt(2, ofertante);
			statement.setInt(3, item);
			
			
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
	
	public void listar(Integer categoria) {
		
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		ResultSet rs = null;
		String sql = "SELECT i.nome AS item, u.nome AS ofertante, o.valor FROM ofertanaodemandada o JOIN usuario u ON o.ofertante = u.id "
				+ "JOIN item i ON o.item_id = i.id";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			
			//statement.setInt(1, categoria);
			
			rs = statement.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("item") + " - " + rs.getString("ofertante") + " - " +  
						rs.getString("valor"));
			}
		}
		catch(SQLException exception) {
			exception.printStackTrace();
			System.out.println("Erro na Listagem de ofertas");
		}
                finally {
                ConnectionFactory.closeConnection(c,ps,rs);
                }
	}
	
	public Integer buscar() {
		return null;
	}
}
