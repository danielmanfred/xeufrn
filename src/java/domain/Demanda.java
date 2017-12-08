package domain;

public class Demanda extends GenericDomain {

	private Usuario solicitador;
	private Item item;
	
	public Usuario getSolicitador() {
		return solicitador;
	}
	public void setSolicitador(Usuario solicitador) {
		this.solicitador = solicitador;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
