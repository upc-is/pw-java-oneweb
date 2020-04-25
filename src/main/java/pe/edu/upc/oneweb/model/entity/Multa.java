package pe.edu.upc.oneweb.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "multas")
public class Multa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "detenido_id")
	private Detenido detenido;
	
	@Column(name = "fecha_detencion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDetencion;
	
	@Column(name = "direccion", length = 40, nullable = false)
	private String direccion;
	
	@Column(name = "infraccion", length = 10, nullable = false)
	private String infraccion;
	
	@Column(name = "monto", nullable = false )
	private double monto; 
}










