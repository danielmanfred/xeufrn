package service;

import dao.DemandaDAO;

public class DemandaService {
	
	private DemandaDAO dao;
	
	public DemandaService() {
		dao = new DemandaDAO();
	}
	
	public void criarDemanda(Integer solicitador, Integer item) {
		dao.salvar(solicitador, item);
	}
	
}
