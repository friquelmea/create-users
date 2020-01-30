package cl.globallogic.friquelme.converter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cl.globallogic.friquelme.dto.UserResponseDTO;
import cl.globallogic.friquelme.entity.User;

@Component
public class UserToUserResponseDTOConverter implements Converter<User, UserResponseDTO>{

	Logger logger = LoggerFactory.getLogger(UserDTOToUserConverter.class);
	
	@Override
	public UserResponseDTO convert(User source) {
		logger.info("UserToUserResponseDTOConverter::convert");
		UserResponseDTO user = new UserResponseDTO(source.getId(), convertDateToLocalDate(source.getCreated()), 
				convertDateToLocalDate(source.getModified()), convertDateToLocalDate(source.getLastLogin()), 
				source.getToken(), source.getIsActive());
		
		return user;
	}
	
	private LocalDate convertDateToLocalDate(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

}
