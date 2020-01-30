package cl.globallogic.friquelme.converter;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cl.globallogic.friquelme.dto.PhoneDTO;
import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.entity.User;

@Component
public class UserToUserDTOConverter implements Converter<User, UserDTO>{

	@Override
	public UserDTO convert(User source) {
		
		UserDTO user = new UserDTO(source.getName(), source.getEmail(), source.getPassword(), null);
		if(source.getPhones() != null && !source.getPhones().isEmpty()) {
			user.setPhones(new ArrayList<PhoneDTO>());
			source.getPhones().forEach(t -> user.getPhones().add(new PhoneDTO(t.getNumber(),t.getCityCode(),t.getCountryCode())));
		}
		return user;
	}

}
