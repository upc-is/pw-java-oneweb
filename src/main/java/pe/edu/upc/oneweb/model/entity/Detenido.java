package pe.edu.upc.oneweb.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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

@Entity
@Table(name = "detenidos")
public class Detenido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;
	
	@Column(name = "nombres", length = 30, nullable = false)
	private String nombres;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "distrito", length = 40, nullable = false)
	private String distrito;
	
	// mappedBy: El objeto de relación
	// fetch: 
	@OneToMany(mappedBy = "detenido", fetch = FetchType.LAZY)
	private List<Multa> multas;
	
	// joinColumns: Son los atributos de la clase Origen (actual)
	// inverseJoinColumns: Son los atributos de la clase Destino (a relacionarme)
	@ManyToMany
	@JoinTable(name = "detenido_comisaria", 
		joinColumns = { @JoinColumn(name = "detenido_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "comisaria_id", referencedColumnName = "id") } )
	private List<Comisaria> comisarias;
	
	public Detenido() {
		multas =  new ArrayList<>();
		comisarias = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public List<Multa> getMultas() {
		return multas;
	}

	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}

	public List<Comisaria> getComisarias() {
		return comisarias;
	}

	public void setComisarias(List<Comisaria> comisarias) {
		this.comisarias = comisarias;
	}
	
	@Override
    public String toString() {
        return dni;
    }
	
}

