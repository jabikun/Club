package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Corredores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCorredor;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "corredores")
	private List<Pruebas> challenges = new ArrayList<>();
	
	@ManyToOne
	private Clubes club;
	
	private String name;
	private String surname;
	private String city;

	public Integer getIdCorredor() {
		return idCorredor;
	}

	public void setIdCorredor(Integer idCorredor) {
		this.idCorredor = idCorredor;
	}

	public List<Pruebas> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<Pruebas> challenges) {
		this.challenges = challenges;
	}
	
	public Clubes getClub() {
		return club;
	}

	public void setClub(Clubes club) {
		this.club = club;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}