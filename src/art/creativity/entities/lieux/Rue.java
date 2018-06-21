package art.creativity.entities.lieux;

import java.io.Serializable;

public class Rue implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 713959665262266745L;
	private Long id;
	private String libelle;
	private Qtier qtier;
	
	public Rue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Rue(String libelle, Qtier qtier) {
		super();
		this.libelle = libelle;
		this.qtier = qtier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Qtier getQtier() {
		return qtier;
	}
	public void setQtier(Qtier qtier) {
		this.qtier = qtier;
	}
	
	

}
