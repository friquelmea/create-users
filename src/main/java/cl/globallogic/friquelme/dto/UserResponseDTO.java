package cl.globallogic.friquelme.dto;

import java.time.LocalDate;

public class UserResponseDTO {

	private String id;
	private LocalDate created;
	private LocalDate modified;
	private LocalDate last_login;
	private String token;
	private Boolean isActive;
	
	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserResponseDTO(String id, LocalDate created, LocalDate modified, LocalDate last_login, String token, Boolean isActive) {
		super();
		this.id = id;
		this.created = created;
		this.modified = modified;
		this.last_login = last_login;
		this.token = token;
		this.isActive = isActive;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LocalDate getCreated() {
		return created;
	}
	public void setCreated(LocalDate created) {
		this.created = created;
	}
	public LocalDate getModified() {
		return modified;
	}
	public void setModified(LocalDate modified) {
		this.modified = modified;
	}
	public LocalDate getLast_login() {
		return last_login;
	}
	public void setLast_login(LocalDate last_login) {
		this.last_login = last_login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "UserResponseDTO [id=" + id + ", created=" + created + ", modified=" + modified + ", last_login="
				+ last_login + ", token=" + token + ", isActive=" + isActive + "]";
	}
	
	
	
}
