package pe.edu.upc.oneweb.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.oneweb.business.MultaBusiness;
import pe.edu.upc.oneweb.model.entity.Multa;
import pe.edu.upc.oneweb.model.repository.MultaRepository;

@Named
public class MultaBusinessImpl implements MultaBusiness, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private MultaRepository multaRepository;

	@Override
	@Transactional
	public Integer create(Multa t) throws Exception {
		return multaRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Multa t) throws Exception {
		return multaRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Multa t) throws Exception {
		return multaRepository.delete(t);
	}

	@Override
	public List<Multa> readAll() throws Exception {
		return multaRepository.findAll();
	}

	@Override
	public Optional<Multa> readById(Integer id) throws Exception {
		return multaRepository.findById(id);
	}

}
