package cl.globallogic.friquelme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 280667165636187787L;

	public UserNotFoundException(String message) {
		super(message);
	}

	
}
