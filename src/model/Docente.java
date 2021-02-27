package model;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "docente")
public class Docente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "iddocente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "nome")
	@NotEmpty(message = "nome obbligatorio")
	@Size(min = 2, max = 45, message = "minimo 2 lettere per il nome, massimo 45")

	private String nome;

	@Column(name = "cognome")
	@NotEmpty(message = "cognome obbligatorio")
	@Size(min = 2, max = 45, message = "minimo 2 lettere per il cognnome, massimo 45")

	private String cognome;
	@Transient
	private LinkedHashMap<Integer, String> listaCorsi;

	@ManyToOne(cascade= { CascadeType.MERGE,
			})
	private Corsi corsi;

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

	public Docente(Integer id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Docente() {
		this.listaCorsi =new LinkedHashMap<Integer, String>();
	}

	public Corsi getCorsi() {
		return corsi;
	}

	public void setCorsi(Corsi corsi) {
		this.corsi = corsi;
	}

	public String getNomeCorsi() {
		return corsi.getNomecorso();
	}

	public LinkedHashMap<Integer, String> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(LinkedHashMap<Integer, String> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}
}
