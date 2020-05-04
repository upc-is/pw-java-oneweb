package pe.edu.upc.oneweb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.edu.upc.oneweb.business.DetenidoBusiness;
import pe.edu.upc.oneweb.model.entity.Detenido;

@Named
@ViewScoped
public class DetenidoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DetenidoBusiness detenidoBusiness;
	
	private Detenido detenido;
	private Detenido detenidoSelected;
	private List<Detenido> detenidos;
	
	@PostConstruct
	public void init() {
		detenido = new Detenido();
		detenidoSelected = new Detenido();
		loadDetenidos();
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
		detenido = new Detenido();
		detenido.setDistrito("Villa");
		detenidoSelected = null;
	}
	
	// Método para guardar los datos del Detenido
	public void saveDetenido() {
		try {
			if(detenido.getId() > 0)
				detenidoBusiness.update(detenido);
			else			
				detenidoBusiness.create(detenido);
			loadDetenidos();
			resetForm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Método que transfiere el objeto seleccionado a detenidoSelected
	public void selectDetenido(SelectEvent e) {
		detenidoSelected = (Detenido)e.getObject();
	}
	
	// Método que permite enviar la data del detenido seleccionado al formulario
	public void editDetenido() {
		if(detenidoSelected.getId() > 0)
			detenido = detenidoSelected;
		else
			System.out.println("No selecciono un detenido");
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
