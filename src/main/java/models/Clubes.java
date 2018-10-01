package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Clubes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idClub;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clubes")
	private List<Corredores> runners = new ArrayList<>();
	
	private String name;
	private String city;

	public Integer getIdClub() {
		return idClub;
	}

	public void setIdClub(Integer idClub) {
		this.idClub = idClub;
	}

	public List<Corredores> getRunners() {
		return runners;
	}

	public void setRunners(List<Corredores> runners) {
		this.runners = runners;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
