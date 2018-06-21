package art.creativity.entities;

import art.creativity.entities.identities.Abonne;
import art.creativity.entities.identities.Agence;
import java.io.Serializable;
import java.util.Date;


public class Secouru implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1348040293769198989L;
	private Long id;
	private Abonne abonne;
	private Agence agence;
	private Date declache;
	private String typeIntervension;
	private Date finIntervension;
	private String resultat;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Abonne getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public Date getDeclache() {
		return declache;
	}
	public void setDeclache(Date declache) {
		this.declache = declache;
	}
	public String getTypeIntervension() {
		return typeIntervension;
	}
	public void setTypeIntervension(String typeIntervension) {
		this.typeIntervension = typeIntervension;
	}
	public Date getFinIntervension() {
		return finIntervension;
	}
	public void setFinIntervension(Date finIntervension) {
		this.finIntervension = finIntervension;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public Secouru(Abonne abonne, Agence agence, Date declache) {
		super();
		this.abonne = abonne;
		this.agence = agence;
		this.declache = declache;
	}
	public Secouru() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
