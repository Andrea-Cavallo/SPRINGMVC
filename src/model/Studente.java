package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="studente")
public class Studente implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	@NotEmpty(message = "nome obbligatorio")
	@Size(min=2, max=45, message = "minimo 2 lettere per il nome, massimo 45")
	private String nome;
	
	@Column(name = "cognome")
	@Size(min=2, max=45, message = "minimo 2 lettere per il cognome, massimo 45")
	@NotEmpty(message = "cognome obbligatorio")
	private String cognome;
	
	@Transient
	private String nominativo;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
	  name = "frequenza", 
	  joinColumns = @JoinColumn(name = "idstudenti"), 
	  inverseJoinColumns = @JoinColumn(name = "idcorsi"))
	List<Corsi> corsi = new ArrayList<Corsi>();
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private Dettaglio dettaglio;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public List<Corsi> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corsi> corsi) {
		this.corsi = corsi;
	}
	
	public String getNominativo() 
	{
		return this.nome + " " + this.cognome;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Studente other = (Studente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Studente(Integer id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Studente() {
	}

	@Override
	public String toString() {
		return  + id + ", " + nome + ", " + cognome ;
	}




}
