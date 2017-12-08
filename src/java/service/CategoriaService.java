package service;

import java.util.List;

import dao.CategoriaDAO;
import domain.Categoria;
import java.util.ArrayList;

public class CategoriaService {
	
	private List<Categoria> categorias;
	private Categoria categoria;
	@SuppressWarnings("unused")
	private CategoriaDAO dao;
	
	public CategoriaService() {
		dao = new CategoriaDAO();
                categorias = new ArrayList<>();
	}
        
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void salvar(String nome) {
            dao.salvar(nome);
	}
	
	public Integer buscar(Integer id) {
		return 0;
	}
	
	public List<Categoria> buscarCategorias() {
            return dao.listar();            
	}
}
