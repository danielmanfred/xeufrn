package domain;

public class Oferta extends GenericDomain {

	private Double valor;
	private Usuario ofertante;
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Usuario getOfertante() {
		return ofertante;
	}
	public void setOfertante(Usuario ofertante) {
		this.ofertante = ofertante;
	}
	
	
}
