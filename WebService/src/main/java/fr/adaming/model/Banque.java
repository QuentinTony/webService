package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="banques")
public class Banque implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long numeroCarte;
	
	@Temporal(TemporalType.DATE)
	private Date dateExperiation;
	private int cleSecurite;
	private Double solde;
	
	
	
	public Banque() {
		super();
	}
	public Banque(long numeroCarte, Date dateExperiation, int cleSecurite, Double solde) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateExperiation = dateExperiation;
		this.cleSecurite = cleSecurite;
		this.solde = solde;
	}
	
	
	public Banque(long id, long numeroCarte, Date dateExperiation, int cleSecurite, Double solde) {
		super();
		this.id = id;
		this.numeroCarte = numeroCarte;
		this.dateExperiation = dateExperiation;
		this.cleSecurite = cleSecurite;
		this.solde = solde;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumeroCarte() {
		return numeroCarte;
	}
	public void setNumeroCarte(long numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
	public Date getDateExperiation() {
		return dateExperiation;
	}
	public void setDateExperiation(Date dateExperiation) {
		this.dateExperiation = dateExperiation;
	}
	public int getCleSecurite() {
		return cleSecurite;
	}
	public void setCleSecurite(int cleSecurite) {
		this.cleSecurite = cleSecurite;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	@Override
	public String toString() {
		return "Banque [id=" + id + ", numeroCarte=" + numeroCarte + ", dateExperiation=" + dateExperiation
				+ ", cleSecurite=" + cleSecurite + ", solde=" + solde + "]";
	}
	
	
	
	
	
	
	

}
