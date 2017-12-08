package service;

import dao.OfertaNaoDemandadaDAO;

public class OfertaNaoDemandadaService {
	
	private OfertaNaoDemandadaDAO dao;
	
	public OfertaNaoDemandadaService() {
		dao = new OfertaNaoDemandadaDAO();
	}
	
	public void adicionarOferta(Double valor, Integer ofertante, Integer item) {
		dao.salvar(valor, ofertante, item);
	}
	
	public void listarOfertas(Integer categoria) {
		dao.listar(categoria);
	}
	
	public void buscarOferta() {
		
	}
}
