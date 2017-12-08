package service;

public class SelecaoOfertaDemandada extends SelecaoOferta {

	@Override
	public void realizarNegocio(Integer oferta) {
		NegocioService ns = new NegocioService();
		
		ns.adicionarNegocioDemandado(oferta);
	}

	@Override
	public void notificarOfertor() {
		// TODO Auto-generated method stub

	}

}
