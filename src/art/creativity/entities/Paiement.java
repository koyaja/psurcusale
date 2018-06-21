package art.creativity.entities;

import art.creativity.entities.identities.Abonne;
import art.creativity.entities.identities.Employe;
import java.io.Serializable;
import java.util.Date;

public class Paiement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 585916214323605562L;
	private String id;
	private Date date;
	private String motif;
	private Abonne abonne;
	private Employe employe;
	private boolean payer;
	private Employe caissier;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public Abonne getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public boolean isPayer() {
		return payer;
	}
	public void setPayer(boolean payer) {
		this.payer = payer;
	}
	public Employe getCaissier() {
		return caissier;
	}
	public void setCaissier(Employe caissier) {
		this.caissier = caissier;
	}
	public Paiement(String id, Date date, String motif, Abonne abonne, Employe employe) {
		super();
		this.id = id;
		this.date = date;
		this.motif = motif;
		this.abonne = abonne;
		this.employe = employe;
	}
	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}
}
