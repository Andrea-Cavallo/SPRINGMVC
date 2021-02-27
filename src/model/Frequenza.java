package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frequenza")
public class Frequenza implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idfrequenza")
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idfrequenza;
	
	@Column(name = "idcorsi")
	private Integer idcorsi;
	
	@Column(name = "idstudenti")
	private Integer idstudenti;
	
	@OneToOne
	private Corsi corsi;

	
	

	public Integer getIdfrequenza() {
		return idfrequenza;
	}

	public void setIdfrequenza(Integer idfrequenza) {
		this.idfrequenza = idfrequenza;
	}

	public Integer getIdcorsi() {
		return idcorsi;
	}

	public void setIdcorsi(Integer idcorsi) {
		this.idcorsi = idcorsi;
	}

	public Integer getIdstudenti() {
		return idstudenti;
	}

	public void setIdstudenti(Integer idstudenti) {
		this.idstudenti = idstudenti;
	}


	@Override
	public String toString() {
		return  + idfrequenza + ", " + idcorsi + ", " + idstudenti ;
	}

	public Frequenza(Integer idfrequenza, Integer idcorsi, Integer idstudenti) {
		this.idfrequenza = idfrequenza;
		this.idcorsi = idcorsi;
		this.idstudenti = idstudenti;
	}
	public Frequenza() {}

}
