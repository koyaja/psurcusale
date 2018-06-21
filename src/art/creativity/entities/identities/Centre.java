package art.creativity.entities.identities;

import art.creativity.entities.lieux.Adresse;
import java.io.Serializable;
import java.util.Collection;


public abstract class Centre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8079176690162732717L;
	private Long id;
	private String type;
	private Adresse adresse;
	private Employe employeGerant;
	private Collection<Employe> employes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Employe getEmployeGerant() {
		return employeGerant;
	}
	public void setEmployeGerant(Employe employeGerant) {
		this.employeGerant = employeGerant;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Centre(String type, Adresse adresse, String libelle) {
		super();
		this.type = type;
		this.adresse = adresse;
		this.libelle = libelle;
	}
	public Centre() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String libelle;
}
