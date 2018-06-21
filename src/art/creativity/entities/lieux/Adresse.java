package art.creativity.entities.lieux;

import java.io.Serializable;

public class Adresse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059189531280767850L;
	private Long id;
	private String lot;
	private Rue rue;
	private Zone zone;
	private String plan;
	
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Adresse(String lot, Rue rue, Zone zone, String plan) {
		super();
		this.lot = lot;
		this.rue = rue;
		this.zone = zone;
		this.plan = plan;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}
	public Rue getRue() {
		return rue;
	}
	public void setRue(Rue rue) {
		this.rue = rue;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
}
