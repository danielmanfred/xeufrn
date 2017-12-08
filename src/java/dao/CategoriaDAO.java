package dao;

import domain.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;

public class CategoriaDAO{
        
	public void salvar(String nome) {
		
                Connection c = ConnectionFactory.getConnection();
                PreparedStatement ps = null;
            
		String sql = "INSERT INTO categoria (nome) VALUES (?)";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, nome);
			statement.executeUpdate();
			System.out.println("A categoria foi adicionada");
                        System.out.println("Categoria salva com sucesso");
		}
		catch (SQLException e) {
			System.out.println("Erro ao adicionar a categoria");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
	
        public List<Categoria> listar() {
            
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            List<Categoria> categorias = new ArrayList<>();
            String sql = "SELECT * FROM categoria ORDER BY nome";
            
            try {
                PreparedStatement statement = c.prepareStatement(sql);
                
                rs = statement.executeQuery();
                
                while(rs.next()) {
                    Categoria categoria = new Categoria();

                    categoria.setId(rs.getInt("id"));
                    categoria.setNome(rs.getString("nome"));
                    
                    categorias.add(categoria);  
                }
                
                System.out.println("Lista de categorias foi retornado");
            }
            catch (SQLException e) {
                e.printStackTrace();
		System.out.println("Erro: não foi possível listar as categorias");
            }
            finally {
                ConnectionFactory.closeConnection(c,ps,rs);
            }   
             
            return categorias;
        }

}
