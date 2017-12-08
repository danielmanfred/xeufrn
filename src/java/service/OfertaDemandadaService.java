package service;

import dao.OfertaDemandadaDAO;

public class OfertaDemandadaService {
	
	private OfertaDemandadaDAO dao;
	
	public OfertaDemandadaService() {
		dao = new OfertaDemandadaDAO();
	}
	
	public void adicionarOferta(Double valor, Integer ofertante, Integer demanda) {
		dao.salvar(valor, ofertante, demanda);
	}
	
}
