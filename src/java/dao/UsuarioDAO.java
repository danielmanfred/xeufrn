package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Usuario;
import java.sql.Connection;
import util.ConnectionFactory;

public class UsuarioDAO {
	
	public UsuarioDAO() {
		
	}
	
	public void salvar(String nome, String senha) {

            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "INSERT INTO usuario (nome, nota, senha) VALUES (?,?,?)";
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			statement.setString(1, nome);
			statement.setInt(2, 0);
			statement.setString(3, senha);
			statement.executeUpdate();
			System.out.println("Conta criada com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na cria��o da conta");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
	
	public Usuario logar(String nome, String senha) {
            
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
		
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setString(2, senha);
			rs = statement.executeQuery();
			
			if(rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setNota(rs.getInt("nota"));
				usuario.setSenha(rs.getString("senha"));
				System.out.println("Login efetuado com sucesso");
			}
			else {
				System.out.println("Informa��es de login incorretas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na login");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps,rs);
                }

		return usuario;
	}
        
        public Usuario logar(String nome) {
            
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
		
		Usuario usuario = new Usuario();
		
		String sql = "SELECT * FROM usuario WHERE nome = ?";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);

			statement.setString(1, nome);
			rs = statement.executeQuery();
			
			if(rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setNota(rs.getInt("nota"));
				usuario.setSenha(rs.getString("senha"));
				System.out.println("Login efetuado com sucesso");
			}
			else {
				System.out.println("Informa��es de login incorretas");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na login");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps,rs);
                }

		return usuario;
	}
	
	public void excluirConta(Integer id) {

            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "DELETE FROM usuario WHERE id = ?";

		try {
			PreparedStatement statement = c.prepareStatement(sql);

			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("Conta exclu�da sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na remo��o da conta");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}
	
	
	public void alterarNome(Integer id, String nome) {
		
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		String sql = "UPDATE usuario SET nome = ? WHERE id = ?";

		try {
			PreparedStatement statement = c.prepareStatement(sql);

			statement.setString(1, nome);
			statement.setInt(2, id);
			statement.executeUpdate();
			System.out.println("Nome alterado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na altera��o do nome");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
	}

	public List<Usuario> listar() {
	
            Connection c = ConnectionFactory.getConnection();
            PreparedStatement ps = null;
            
		List<Usuario> usuarios = new ArrayList<>();
		
		String sql = "SELECT * FROM usuario";
		
		try {
			PreparedStatement statement = c.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setNota(rs.getInt("nota"));
				usuario.setSenha(rs.getString("senha"));
				
				usuarios.add(usuario);
			}
			
			System.out.println("Lista de usu�rios retornados com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\nErro na listagem de usu�rios");
		}
                finally {
                    ConnectionFactory.closeConnection(c,ps);
                }
		
		return usuarios;
	}
	
}
