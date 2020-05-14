package pe.edu.upc.oneweb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.oneweb.business.DetenidoBusiness;
import pe.edu.upc.oneweb.business.MultaBusiness;
import pe.edu.upc.oneweb.model.entity.Detenido;
import pe.edu.upc.oneweb.model.entity.Multa;
import pe.edu.upc.oneweb.utils.Accion;

@Named
@ViewScoped
public class MultaController implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Inject
	private MultaBusiness multaBusiness;
	
	@Inject
	private DetenidoBusiness detenidoBusiness;
	
	private Multa multa;
	private Multa multaSelected;
	private List<Multa> multas;
	private List<Detenido> detenidos;
	private Accion accion;
	
	@PostConstruct
	public void init() {
		multa = new Multa();
		multaSelected = new Multa();
		loadMultas();
		loadDetenidos();
		accion = Accion.NONE;
	}
	// Método para cargar la lista de multas
	public void loadMultas() {
		try {
			multas = multaBusiness.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Método para cargar la lista de detenidos
	public void loadDetenidos() {
		try {
			detenidos = detenidoBusiness.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Método para registra un nuevo detenido: Resetear el formulario
	public void resetForm() {
		multa = new Multa();
		multaSelected = null;
		accion = Accion.NUEVO;
		addMessage("Limpiando el formulario para un nuevo elemento");
	}
	
	// Método para guardar los datos del Detenido
	public void saveMulta() {
		if(multa.getInfraccion().isEmpty()|| multa.getFechaDetencion() == null) {
			addMessage("La infraccción o la Fecha de detencion esta vacio, por favor ingresar para guardar");
		}
		else {
		
			try {
				if(accion == Accion.EDITAR) {
					multaBusiness.update(multa);
					addMessage("La multa se actualizo correctamente");
				}					
				else if (accion == Accion.NUEVO) {
					multaBusiness.create(multa);
					addMessage("La multa se grabo correctamente");
				}
					
				loadMultas();
				resetForm();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	// Método que transfiere el objeto seleccionado a detenidoSelected
	public void selectMulta(SelectEvent e) {
		multaSelected = (Multa)e.getObject();
	}
	
	// Método que permite enviar la data del detenido seleccionado al formulario
	public void editMulta() {
		if(multaSelected.getId() > 0) {
			multa = multaSelected;
			accion = Accion.EDITAR;
		}
			
		else
			addMessage("No selecciono un elmento");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public Multa getMulta() {
		return multa;
	}
	public void setMulta(Multa multa) {
		this.multa = multa;
	}
	public Multa getMultaSelected() {
		return multaSelected;
	}
	public void setMultaSelected(Multa multaSelected) {
		this.multaSelected = multaSelected;
	}
	public List<Multa> getMultas() {
		return multas;
	}
	public void setMultas(List<Multa> multas) {
		this.multas = multas;
	}
	public List<Detenido> getDetenidos() {
		return detenidos;
	}
	public void setDetenidos(List<Detenido> detenidos) {
		this.detenidos = detenidos;
	}
	
}
