package cl.globallogic.friquelme.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		logger.info("UserController::getAllUsers");
		return new ResponseEntity<>(userService.getUsers(),
				HttpStatus.OK);
	}
}
