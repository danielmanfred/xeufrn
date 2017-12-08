package service;

public abstract class SelecaoOferta {
	
	public void selecionarOferta(Integer oferta) {
		realizarNegocio(oferta);
		notificarOfertor();
	}
	
	public abstract void realizarNegocio(Integer oferta);
	
	public abstract void notificarOfertor();
}
