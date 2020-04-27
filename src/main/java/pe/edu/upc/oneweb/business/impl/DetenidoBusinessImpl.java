package pe.edu.upc.oneweb.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.oneweb.business.DetenidoBusiness;
import pe.edu.upc.oneweb.model.entity.Detenido;
import pe.edu.upc.oneweb.model.repository.DetenidoRepository;

@Named
public class DetenidoBusinessImpl implements DetenidoBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DetenidoRepository detenidoRepository;
	
	@Override
	public Integer create(Detenido t) throws Exception {
		return detenidoRepository.insert(t);
	}

	@Override
	public Integer update(Detenido t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(Detenido t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detenido> readAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Detenido> readById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Detenido> readByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detenido> readByApellidos(String apellidos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
