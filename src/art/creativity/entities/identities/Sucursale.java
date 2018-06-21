package art.creativity.entities.identities;

import art.creativity.entities.lieux.Adresse;


public class Sucursale extends Centre{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5896784615937460999L;
	private String nomPhoto;
	private String photo;
	public Sucursale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sucursale(String typeCentre, Adresse adresse, String libelle) {
		super(typeCentre, adresse, libelle);
		// TODO Auto-generated constructor stub
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
