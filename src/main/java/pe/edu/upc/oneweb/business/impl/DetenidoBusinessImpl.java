package pe.edu.upc.oneweb.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.oneweb.business.DetenidoBusiness;
import pe.edu.upc.oneweb.model.entity.Detenido;
import pe.edu.upc.oneweb.model.repository.DetenidoRepository;

@Named
@ApplicationScoped
public class DetenidoBusinessImpl implements DetenidoBusiness, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DetenidoRepository detenidoRepository;
	
	@Override
	@Transactional
	public Integer create(Detenido t) throws Exception {
		return detenidoRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Detenido t) throws Exception {
		return detenidoRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Detenido t) throws Exception {
		return detenidoRepository.delete(t);
	}

	@Override
	public List<Detenido> readAll() throws Exception {
		return detenidoRepository.findAll();
	}

	@Override
	public Optional<Detenido> readById(Integer id) throws Exception {
		return detenidoRepository.findById(id);
	}

	@Override
	public Optional<Detenido> readByDni(String dni) throws Exception {
		return detenidoRepository.findByDni(dni);
	}

	@Override
	public List<Detenido> readByApellidos(String apellidos) throws Exception {
		return detenidoRepository.findByApellidos(apellidos);
	}

}
