package art.creativity.entities.identities;

import art.creativity.entities.lieux.Adresse;


public class Agence extends Centre{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8611916948106917798L;


	public Agence(Adresse adresse, String libelle, String type) {
		super(type, adresse, libelle);
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
}
