package cl.globallogic.friquelme.exception;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler 
extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest we){
		ExceptionResponse exception =
		new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserExistsException.class)
	public final ResponseEntity<Object> userExistsException(Exception ex, WebRequest we){
		ExceptionResponse exception =
		new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(exception, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> userNotFoundException(Exception ex, WebRequest we){
		ExceptionResponse exception =
		new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnauthorizedUserException.class)
	public final ResponseEntity<Object> userUnauthorizedException(Exception ex, WebRequest we){
		ExceptionResponse exception =
		new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(exception, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(InvalidDataException.class)
	public final ResponseEntity<Object> invalidDataException(Exception ex, WebRequest we){
		ExceptionResponse exception =
		new ExceptionResponse(ex.getMessage());
		
		return new ResponseEntity<Object>(exception, HttpStatus.PRECONDITION_FAILED);
	}
	
	@ExceptionHandler(ConversionFailedException.class)
	public final ResponseEntity<Object> conversionFailedException(Exception ex, WebRequest we){
		ExceptionResponse exception =
		new ExceptionResponse(ex.getCause().getMessage());
		
		return new ResponseEntity<Object>(exception, HttpStatus.PRECONDITION_FAILED);
	}
}
