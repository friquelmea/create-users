package cl.globallogic.friquelme.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.dto.UserResponseDTO;
import cl.globallogic.friquelme.exception.InvalidDataException;
import cl.globallogic.friquelme.service.RegisterService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegisterControllerTest {

	@Mock
    private HttpServletResponse response;
	@Mock
	private RegisterService registerService;
	@InjectMocks
	private RegisterController registerController;
	
	@Test
	public void agregarUsuariosTestOK() {
		UserDTO user = new UserDTO("Francisco", "fco.talca@gmail.com", "elmenor", null);
		Date now = new Date();
		UserResponseDTO userResponse = new UserResponseDTO("UU345",now, now,now,"ASDOMG",true);
		when(registerService.registerUser(any(), anyString())).thenReturn(userResponse);
		when(response.getHeader(anyString())).thenReturn("OMR");
		assertTrue(registerController.registerUser(user, response).getStatusCode().equals(HttpStatus.CREATED));
	}
	
	@Test(expected=InvalidDataException.class)
	public void agregarUsuariosPassNOK() {
		when(registerService.registerUser(any(), anyString())).thenThrow(InvalidDataException.class);
		when(response.getHeader(anyString())).thenReturn("OMR");
		registerController.registerUser(new UserDTO(), response);
	}
}
