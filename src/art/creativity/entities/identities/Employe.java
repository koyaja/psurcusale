package art.creativity.entities.identities;

public class Employe extends Profil {

	/**
	 * 
	 */
	private static final long serialVersionUID = -131335989252325996L;
	private String status;
	private Employe employeGerant;
	private Centre centre;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Employe getEmployeGerant() {
		return employeGerant;
	}
	public void setEmployeGerant(Employe employeGerant) {
		this.employeGerant = employeGerant;
	}
	public Centre getCentre() {
		return centre;
	}
	public void setCentre(Centre centre) {
		this.centre = centre;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(String status) {
		super();
		this.status = status;
	}
	
}
