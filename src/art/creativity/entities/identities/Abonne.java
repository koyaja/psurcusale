package art.creativity.entities.identities;

public class Abonne extends Profil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6981072600597784272L;
	private Long numeroAB;
	private Employe employe;
        private String tel;
        private String adres;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
        
        
	public Long getNumeroAB() {
		return numeroAB;
	}
	public void setNumeroAB(Long numeroAB) {
		this.numeroAB = numeroAB;
	}
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Abonne(Long numeroAB, Employe employe) {
		super();
		this.numeroAB = numeroAB;
		this.employe = employe;
	}
	public Abonne() {
		super();
		// TODO Auto-generated constructor stub
	}

}
