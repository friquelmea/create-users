package cl.globallogic.friquelme.service;

import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.dto.UserResponseDTO;

public interface RegisterService {

	public UserResponseDTO registerUser(UserDTO user,String token);

}
