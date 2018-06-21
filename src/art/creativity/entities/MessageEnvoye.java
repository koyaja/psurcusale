package art.creativity.entities;

import art.creativity.entities.identities.Abonne;
import art.creativity.entities.identities.Employe;
import java.io.Serializable;
import java.util.Date;

public class MessageEnvoye implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4045850114443857897L;
	private Long id;
	private Date date;
	private String motif;
	private Abonne abonne;
	private Employe employe;
	private String message;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MessageEnvoye(Date date, String motif, Abonne abonne, Employe employe, String message) {
		super();
		this.date = date;
		this.motif = motif;
		this.abonne = abonne;
		this.employe = employe;
		this.message = message;
	}
	public MessageEnvoye() {
		super();
		// TODO Auto-generated constructor stub
	}
}
