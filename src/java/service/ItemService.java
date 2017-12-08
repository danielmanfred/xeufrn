package service;

import dao.ItemDAO;
import domain.Item;

public class ItemService {
	
	@SuppressWarnings("unused")
	private Item item;
	private ItemDAO dao;
	
	public ItemService() {
		dao = new ItemDAO();
	}
	
	public Integer adicionarItem(String nome, String descricao, Integer categoria) {
		dao.salvar(nome, descricao, categoria);
		
		return dao.buscarItemRecemcriado(nome, categoria);
	}

}
