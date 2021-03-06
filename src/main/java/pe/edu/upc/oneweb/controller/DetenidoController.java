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
import pe.edu.upc.oneweb.model.entity.Detenido;
import pe.edu.upc.oneweb.utils.Accion;

@Named
@ViewScoped
public class DetenidoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetenidoBusiness detenidoBusiness;
	
	private Detenido detenido;
	private Detenido detenidoSelected;
	private List<Detenido> detenidos;
	private Accion accion;
	
	@PostConstruct
	public void init() {
		detenido = new Detenido();
		detenidoSelected = new Detenido();
		loadDetenidos();
		accion = Accion.NONE;
	}
	// M�todo para cargar la lista de detenidos
	public void loadDetenidos() {
		try {
			detenidos = detenidoBusiness.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// M�todo para registra un nuevo detenido: Resetear el formulario
	public void resetForm() {
		detenido = new Detenido();
		detenido.setDistrito("Villa");
		detenidoSelected = null;
		accion = Accion.NUEVO;
		addMessage("Limpiando el formulario para un nuevo Detenido");
	}
	
	// M�todo para guardar los datos del Detenido
	public void saveDetenido() {
		if(detenido.getDni().isEmpty() || detenido.getApellidos().isEmpty() 
				|| detenido.getFechaNacimiento() == null) {
			addMessage("El DNI o el Apellido o la Fecha de nacimiento esta vacio, por favor ingresar para guardar");
		}
		else {
		
			try {
				if(accion == Accion.EDITAR) {
					detenidoBusiness.update(detenido);
					addMessage("El Detenido se actualizo correctamente");
				}					
				else if (accion == Accion.NUEVO) {
					detenidoBusiness.create(detenido);
					addMessage("El Detenido se grabo correctamente");
				}
					
				loadDetenidos();
				resetForm();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
	}
	
	// M�todo que transfiere el objeto seleccionado a detenidoSelected
	public void selectDetenido(SelectEvent e) {
		detenidoSelected = (Detenido)e.getObject();
	}
	
	// M�todo que permite enviar la data del detenido seleccionado al formulario
	public void editDetenido() {
		if(detenidoSelected.getId() > 0) {
			detenido = detenidoSelected;
			accion = Accion.EDITAR;
		}
			
		else
			addMessage("No selecciono un detenido");
	}
	
	public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public DetenidoBusiness getDetenidoBusiness() {
		return detenidoBusiness;
	}

	public void setDetenidoBusiness(DetenidoBusiness detenidoBusiness) {
		this.detenidoBusiness = detenidoBusiness;
	}

	public Detenido getDetenido() {
		return detenido;
	}

	public void setDetenido(Detenido detenido) {
		this.detenido = detenido;
	}

	public Detenido getDetenidoSelected() {
		return detenidoSelected;
	}

	public void setDetenidoSelected(Detenido detenidoSelected) {
		this.detenidoSelected = detenidoSelected;
	}

	public List<Detenido> getDetenidos() {
		return detenidos;
	}

	public void setDetenidos(List<Detenido> detenidos) {
		this.detenidos = detenidos;
	}

	

	
	
}
