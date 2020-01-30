package cl.globallogic.friquelme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class InvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 6501978713144847950L;

	public InvalidDataException(String message) {
		super(message);
	}

	
}
