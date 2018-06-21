package art.creativity.entities.lieux;

import java.io.Serializable;
import java.util.Collection;

public class Qtier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2887310995444456426L;
	private Long id;
	private String libelle;
	private Ville ville;
	private Collection<Rue> rues;
	
	public Qtier(String libelle, Ville ville) {
		super();
		this.libelle = libelle;
		this.ville = ville;
	}
	public Qtier() {
		super();
		// TODO Auto-generated constructor stub
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
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public Collection<Rue> getRues() {
		return rues;
	}
	public void setRues(Collection<Rue> rues) {
		this.rues = rues;
	}
	
}
