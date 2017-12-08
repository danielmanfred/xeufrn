package domain;

import java.util.Date;

public class Negocio extends GenericDomain {
	
	private Date data;
	private Oferta oferta;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Oferta getOferta() {
		return oferta;
	}
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
	
	
}
