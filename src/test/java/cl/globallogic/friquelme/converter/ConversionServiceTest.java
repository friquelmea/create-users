package cl.globallogic.friquelme.converter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.globallogic.friquelme.dto.UserDTO;
import cl.globallogic.friquelme.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConversionServiceTest {

	@Autowired
	private ConversionService conversionService;
	
	@Test
	public void agregarUsuariosMailPassTestOK() {
		UserDTO jhon = new UserDTO("peter", "asdf@asdf.cl", "adsfDD22", null);
		User jhonUser = conversionService.convert(jhon, User.class);
		assertTrue(jhonUser.getEmail().equals("asdf@asdf.cl"));
	}
	
	@Test(expected=ConversionFailedException.class)
	public void agregarUsuariosMailInvalidoTestNOK() {
		UserDTO jhon = new UserDTO("peter", "asdf@asdf", "adsfDD22", null);
		User jhonUser = conversionService.convert(jhon, User.class);
	}
	
	@Test(expected=ConversionFailedException.class)
	public void agregarUsuariosPassInvalidoTestNOK() {
		UserDTO jhon = new UserDTO("peter", "asdf@asdf.cl", "asdf", null);
		User jhonUser = conversionService.convert(jhon, User.class);
	}
}
