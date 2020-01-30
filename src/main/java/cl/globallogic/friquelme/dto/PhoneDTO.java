package cl.globallogic.friquelme.dto;

public class PhoneDTO {

	private String number;
	private String citycode;
	private String countrycode;
	
	public PhoneDTO() {
		super();
	}
	public PhoneDTO(String number, String citycode, String countrycode) {
		super();
		this.number = number;
		this.citycode = citycode;
		this.countrycode = countrycode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	@Override
	public String toString() {
		return "PhoneDTO [number=" + number + ", citycode=" + citycode + ", countrycode=" + countrycode + "]";
	}
	
	
}
