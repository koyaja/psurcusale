package art.creativity.entities.identities;

import java.io.Serializable;

public class Role implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1992304921009179946L;
	private String role;
	private String description;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Role(String role) {
		super();
		this.role = role;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
