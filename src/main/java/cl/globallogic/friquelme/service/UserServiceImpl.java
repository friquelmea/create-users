package cl.globallogic.friquelme.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.entity.User;
import cl.globallogic.friquelme.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userDAO;
	
	@Autowired
	private ConversionService conversionService;

	@Override
	public List<UserDTO> getUsers() {
		List<User> users = userDAO.findAll();
		List<UserDTO> usersDTO = new ArrayList<>();
		if(users != null) {
			List<User> userOverE = 
				    users
				    .stream()
				    .filter(
				        t -> t.getPhones() != null && !t.getPhones().isEmpty()
				    )
				    .collect(Collectors.toList());
			userOverE.forEach(t -> usersDTO.add(conversionService.convert(t, UserDTO.class)));
		}
		return usersDTO;
	}

}
