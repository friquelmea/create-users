package cl.globallogic.friquelme.converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.entity.Phone;
import cl.globallogic.friquelme.entity.User;
import cl.globallogic.friquelme.exception.InvalidDataException;

@Component
public class UserDTOToUserConverter implements Converter<UserDTO, User>{

	Logger logger = LoggerFactory.getLogger(UserDTOToUserConverter.class);
	
	public static final Pattern EMAIL_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	public static final Pattern PASS_REGEX = 
		    Pattern.compile("^(?=.*[0-9]{2,})(?=.*[a-z])(?=.*[A-Z]).{3,}$");
	
	public static final String ERROR_EMAIL = "Debe ingresar un formato de email valido";
	public static final String ERROR_PASS = "Contraseña no cumple con formato requerido";
	
	@Override
	public User convert(UserDTO source) throws InvalidDataException{
		logger.info("userDTOtoUserConverter::converter");
		Date now = new Date();
		validateData(source.getEmail(), EMAIL_REGEX, ERROR_EMAIL);
		validateData(source.getPassword(), PASS_REGEX, ERROR_PASS);
		User user = new User(UUID.randomUUID().toString(), source.getName(), 
				source.getEmail(), source.getPassword(), 
				now, now, now, "", true);
		if(source.getPhones() != null && !source.getPhones().isEmpty()) {
			user.setPhones(new ArrayList<Phone>());
			source.getPhones().forEach(t -> user.getPhones().add(new Phone(t.getNumber(),t.getCitycode(),t.getCountrycode())));
		}
		return user;
	}
	
	private void validateData(String data,final Pattern regex, final String messageError) {
		if(!regex.matcher(data).matches()) {
			logger.error("userDTOtoUserConverter::error "+messageError);
			throw new InvalidDataException(messageError);
		}
	}

}
