package cl.globallogic.friquelme.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.globallogic.friquelme.service.RegisterService;
import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.dto.UserResponseDTO;
import cl.globallogic.friquelme.security.TokenAuthenticationService;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterService registerService;
	
	@PostMapping(path = "/user")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserDTO user,HttpServletResponse response) {
		logger.info("controller::registerUser");
		TokenAuthenticationService.addAuthentication(response, user.getEmail());
		String token = response.getHeader("Authorization");
		UserResponseDTO userResponse = registerService.registerUser(user, token.replace("Bearer ", ""));
		return ResponseEntity.created(null).body(userResponse);
	}
}
