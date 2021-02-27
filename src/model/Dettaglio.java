package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import validation.Cap;

@Entity
@Table(name = "dettaglio")
public class Dettaglio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "matricola")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matricola;
	@Column(name = "cap")
	@Cap(value = "00", message = "il cap deve iniziare con 00")
	private String cap;
	@Column(name = "citta")

	private String citta;
	@Past(message = "Date input is invalid for a birth date.")
	@Column(name = "datadinascita")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datadinascita;

//	@Column(name = "idstudente")
//	private Integer idstudente;

	@OneToOne(mappedBy="dettaglio")
	private Studente studente;

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Date getDatadinascita() {
		return datadinascita;
	}

	public void setDatadinascita(Date datadinascita) {
		this.datadinascita = datadinascita;
	}


	public Studente getStudente() {
		return studente;
	}

	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	public Dettaglio(int matricola, String cap, String citta,
			@Past(message = "Date input is invalid for a birth date.") Date datadinascita, Integer idstudente,
			Studente studente) {
		super();
		this.matricola = matricola;
		this.cap = cap;
		this.citta = citta;
		this.datadinascita = datadinascita;
		this.studente = studente;
	}
	public Dettaglio() {}

	@Override
	public String toString() {
		return "Dettaglio [matricola=" + matricola + ", cap=" + cap + ", citta=" + citta + ", datadinascita="
				+ datadinascita + ", studente=" + studente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((datadinascita == null) ? 0 : datadinascita.hashCode());
		result = prime * result + matricola;
		result = prime * result + ((studente == null) ? 0 : studente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dettaglio other = (Dettaglio) obj;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (datadinascita == null) {
			if (other.datadinascita != null)
				return false;
		} else if (!datadinascita.equals(other.datadinascita))
			return false;
		
		if (matricola != other.matricola)
			return false;
		if (studente == null) {
			if (other.studente != null)
				return false;
		} else if (!studente.equals(other.studente))
			return false;
		return true;
	}
	
	

}
