package pe.edu.upc.oneweb.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	public void loadDetenidos() {
		try {
			detenidoBusiness.readAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
