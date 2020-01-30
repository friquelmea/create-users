package cl.globallogic.friquelme.dto;

import java.util.List;

public class UserDTO {

	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phones;
	
	public UserDTO() {
		super();
	}
	public UserDTO(String name, String email, String password, List<PhoneDTO> phones) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PhoneDTO> getPhones() {
		return phones;
	}
	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", password=" + password + ", phones=" + phones + "]";
	}
	
	
}
