package cl.globallogic.friquelme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedUserException extends RuntimeException {

	private static final long serialVersionUID = -7387665254090079018L;

	public UnauthorizedUserException(String message) {
		super(message);
	}

	
}
