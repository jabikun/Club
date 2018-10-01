package models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pruebas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPrueba;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pruebas")
	private List<Resultados> results = new ArrayList<>();
	
	@ManyToMany
	private Corredores runner;
	
	private String name;
	private Time max_time;

	public Integer getIdPrueba() {
		return idPrueba;
	}

	public void setIdPrueba(Integer idPrueba) {
		this.idPrueba = idPrueba;
	}

	public List<Resultados> getResults() {
		return results;
	}

	public void setResults(List<Resultados> results) {
		this.results = results;
	}
	
	public Corredores getCorredor() {
		return runner;
	}

	public void setCorredor(Corredores runner) {
		this.runner = runner;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getMaxTime() {
		return max_time;
	}

	public void setMaxTime(Time max_time) {
		this.max_time = max_time;
	}
	
}