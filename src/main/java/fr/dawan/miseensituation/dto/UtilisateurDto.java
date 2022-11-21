package fr.dawan.miseensituation.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UtilisateurDto implements Serializable {

	//private static final long serialVersionUID = 6910611991104309703L;

	private long id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;

	private boolean active;

	private String role;

	private int version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UtilisateurDto() {
		super();
	}
}
