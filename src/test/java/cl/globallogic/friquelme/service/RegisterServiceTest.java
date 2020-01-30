package cl.globallogic.friquelme.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.globallogic.friquelme.dao.RegisterDAO;
import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.dto.UserResponseDTO;
import cl.globallogic.friquelme.entity.User;
import cl.globallogic.friquelme.exception.UserExistsException;
import cl.globallogic.friquelme.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegisterServiceTest {

	@Mock
	private RegisterDAO registerDAO;
	@Mock
	private UserRepository userDAO;
	@Mock
	private ConversionService conversionService;
	@Mock
	private PasswordEncoder passwordEncoder;
	@InjectMocks
	private RegisterService registerService = new RegisterServiceImpl();
	
	@Test
	public void agregarUsuariosTestOK() {
		Date now = new Date();
		User peterUser = new User("UIO","Peter","asdf@asdf.cl","adsf", now, now, now, "aJkdow",true);
		UserDTO peter = new UserDTO("peter", "asdf@asdf.cl", "adsf", null);
		UserResponseDTO peterResponse = new UserResponseDTO("UIO", now, now, now, "aJkdow", true);
		when(userDAO.getUserByEmail(anyString())).thenReturn(null);
		when(conversionService.convert(peter, User.class)).thenReturn(peterUser);
		doNothing().when(registerDAO).insert(peterUser);
		when(conversionService.convert(peterUser, UserResponseDTO.class)).thenReturn(peterResponse);
		assertTrue(registerService.registerUser(peter, "atfqw").getId().equals("UIO"));
		
	}
	
	@Test(expected=UserExistsException.class)
	public void usuarioYaExiste() {
		Date now = new Date();
		User peterUser = new User("UIO","Peter","asdf@asdf.cl","adsf", now, now, now, "aJkdow",true);
		when(userDAO.getUserByEmail(anyString())).thenReturn(peterUser);
		registerService.registerUser(new UserDTO("peter", "asdf@asdf.cl", "adsf", null), "atfqw");
	}
	
}
