package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConnectionFactory;

public class ItemDAO  {

	public void salvar(String nome, String descricao, Integer categoria) {
		
                Connection c = ConnectionFactory.getConnection();
                PreparedStatement ps = null;
            
		String sql = "INSERT INTO item (nome, descricao, categoria_id) VALUES (?,?,?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setString(2, descricao);
			statement.setInt(3, categoria);
			statement.executeUpdate();
			System.out.println("Item criado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na cria��o do item");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
	
	public Integer buscarItemRecemcriado(String nome, Integer categoria) {
		
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
		
            Integer itemId = null;
            String sql = "SELECT * FROM item WHERE nome = ? AND categoria_id = ?";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			
			statement.setString(1, nome);
			statement.setInt(2, categoria);
			
			rs = statement.executeQuery();
			
			if (rs.next()) {
				itemId = rs.getInt("id");
			}
			else {
				System.out.println("Item n�o foi localizado");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na na busca do item");
		}
                finally {
                ConnectionFactory.closeConnection(c,ps,rs);
                }
		
		return itemId;
	}
}
