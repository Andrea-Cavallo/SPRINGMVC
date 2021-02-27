package exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Corso Assente")

public class NoInfoCorsoFoundException extends RuntimeException {
	private static final long serialVersionUID = 809850541299086904L;

	private String NomeCorso;

	public NoInfoCorsoFoundException(String nomeCorso) {
		this.NomeCorso = nomeCorso;
	}

	public String getNomeCorso() {
		return NomeCorso;
	}

}