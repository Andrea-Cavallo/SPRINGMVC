package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import validation.NomeCorso;

@Entity
@Table(name = "corsi")
public class Corsi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idcorsi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcorsi;

	@Column(name = "nomecorso")
	@NotEmpty(message = "Nome corso obbligatorio")
	@NomeCorso(value="Exo", message="il nome del corso deve iniziare con Exo")

	private String nomecorso;
	

	@Column(name = "datainizio")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datainizio;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corsi")
	List<Docente> docenti;
	
	@ManyToMany( fetch = FetchType.LAZY) //LazyInitializationException: 
	@JoinTable(
	  name = "frequenza", 
	  joinColumns = @JoinColumn(name = "idcorsi"), 
	  inverseJoinColumns = @JoinColumn(name = "idstudenti"))
	List<Studente> studenti = new ArrayList<Studente>();
	

	public Integer getIdcorsi() {
		return idcorsi;
	}

	public void setIdcorsi(Integer idcorsi) {
		this.idcorsi = idcorsi;
	}

	public String getNomecorso() {
		return nomecorso;
	}

	public void setNomecorso(String nomecorso) {
		this.nomecorso = nomecorso;
	}

	public Date getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(Date datainizio) {
		this.datainizio = datainizio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datainizio == null) ? 0 : datainizio.hashCode());
		result = prime * result + ((idcorsi == null) ? 0 : idcorsi.hashCode());
		result = prime * result + ((nomecorso == null) ? 0 : nomecorso.hashCode());
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
		Corsi other = (Corsi) obj;
		if (datainizio == null) {
			if (other.datainizio != null)
				return false;
		} else if (!datainizio.equals(other.datainizio))
			return false;
		if (idcorsi == null) {
			if (other.idcorsi != null)
				return false;
		} else if (!idcorsi.equals(other.idcorsi))
			return false;
		if (nomecorso == null) {
			if (other.nomecorso != null)
				return false;
		} else if (!nomecorso.equals(other.nomecorso))
			return false;
		return true;
	}




	public List<Docente> getDocenti() {
		return docenti;
	}

	public void setDocenti(List<Docente> docenti) {
		this.docenti = docenti;
	}

	public List<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Studente> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public String toString() {
		return  + idcorsi + ", " + nomecorso + ", " + datainizio + ", "
				+ docenti + ", " + studenti ;
	}

	
	public Corsi() {
	}

	public Corsi(Integer idcorsi, String nomecorso, Date datainizio) {
		super();
		this.idcorsi = idcorsi;
		this.nomecorso = nomecorso;
		this.datainizio = datainizio;
	}

	
}
