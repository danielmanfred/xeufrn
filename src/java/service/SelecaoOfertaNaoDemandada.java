package service;

public class SelecaoOfertaNaoDemandada extends SelecaoOferta {

	@Override
	public void realizarNegocio(Integer oferta) {
		NegocioService ns = new NegocioService();
		
		ns.adicionarNegocioNaoDemandado(oferta);
	}

	@Override
	public void notificarOfertor() {
		// TODO Auto-generated method stub
		
	}

	
}
