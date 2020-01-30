package cl.globallogic.friquelme.exception;

public class ExceptionResponse {

	private String mensaje;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
