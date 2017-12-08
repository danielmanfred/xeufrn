package domain;

public class OfertaNaoDemandada extends Oferta {
	
	private Item item;
	private Usuario solicitador;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Usuario getSolicitador() {
		return solicitador;
	}
	public void setSolicitador(Usuario solicitador) {
		this.solicitador = solicitador;
	}
}
