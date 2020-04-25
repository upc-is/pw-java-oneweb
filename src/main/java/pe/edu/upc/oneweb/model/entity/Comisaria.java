package pe.edu.upc.oneweb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comisarias")
public class Comisaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "denominacion", length = 30, nullable = false)	
	private String denominacion;
	
	@Column(name = "distrito", length = 35, nullable = false)
	private String distrito;
	
	@Column(name = "direccion", length = 40, nullable = false)
	private String direccion; 
	
	// mappedBy: El objeto de relación 
	@ManyToMany(mappedBy = "comisarias")
	private List<Detenido> detenidos;	
	
	public Comisaria() {
		detenidos = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion; 
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Detenido> getDetenidos() {
		return detenidos;
	}

	public void setDetenidos(List<Detenido> detenidos) {
		this.detenidos = detenidos;
	}
	
	
	
}












