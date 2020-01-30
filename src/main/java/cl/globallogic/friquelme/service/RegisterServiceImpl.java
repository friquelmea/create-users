package cl.globallogic.friquelme.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.globallogic.friquelme.dao.RegisterDAO;
import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.dto.UserResponseDTO;
import cl.globallogic.friquelme.entity.User;
import cl.globallogic.friquelme.exception.UserExistsException;
import cl.globallogic.friquelme.repository.UserRepository;

@Service
public class RegisterServiceImpl implements RegisterService {

	Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	@Autowired
	private RegisterDAO registerDAO;
	@Autowired
	private UserRepository userDAO;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserResponseDTO registerUser(UserDTO userDTO, String token) {
		logger.info("service::registerUser");
		User user = userDAO.getUserByEmail(userDTO.getEmail());
		UserResponseDTO userResponse = null;
		if(user==null) {
			user = conversionService.convert(userDTO, User.class);
			user.setToken(token.trim());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			registerDAO.insert(user);
			userResponse = conversionService.convert(user, UserResponseDTO.class);
			
		}else {
			logger.info("registerUser::error correo ya existe : "+userDTO.getEmail());
			throw new UserExistsException("El correo ya registrado");
		}
		return userResponse;
	}

}
