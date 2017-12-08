package service;

import dao.NegocioDAO;

public class NegocioService {
	
	private NegocioDAO dao;
	
	public NegocioService() {
		dao = new NegocioDAO();
	}

	public void adicionarNegocioNaoDemandado(Integer oferta) {
		dao.salvarNaoDemandada(oferta);;
	}
	
	public void adicionarNegocioDemandado(Integer oferta) {
		dao.salvarDemandada(oferta);;
	}
}
