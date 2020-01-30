package cl.globallogic.friquelme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserExistsException extends RuntimeException{

	private static final long serialVersionUID = -3741985567711510456L;

	public UserExistsException(String message) {
		super(message);
	}


}
