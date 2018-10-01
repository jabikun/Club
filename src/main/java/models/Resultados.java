package models;

import java.sql.Time;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Resultados {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idResultado;

	private Time time;

	public Integer getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(Integer idResultado) {
		this.idResultado = idResultado;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}