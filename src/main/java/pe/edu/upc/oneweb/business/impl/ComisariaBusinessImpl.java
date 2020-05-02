package pe.edu.upc.oneweb.business.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.edu.upc.oneweb.business.ComisariaBusiness;
import pe.edu.upc.oneweb.model.entity.Comisaria;
import pe.edu.upc.oneweb.model.repository.ComisariaRepository;

@Named
public class ComisariaBusinessImpl implements ComisariaBusiness, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ComisariaRepository comisariaRepository;

	@Override
	@Transactional
	public Integer create(Comisaria t) throws Exception {
		return comisariaRepository.insert(t);
	}

	@Override
	@Transactional
	public Integer update(Comisaria t) throws Exception {
		return comisariaRepository.update(t);
	}

	@Override
	@Transactional
	public Integer delete(Comisaria t) throws Exception {
		return comisariaRepository.delete(t);
	}

	@Override
	public List<Comisaria> readAll() throws Exception {
		return comisariaRepository.findAll();
	}

	@Override
	public Optional<Comisaria> readById(Integer id) throws Exception {
		return comisariaRepository.findById(id);
	}

	@Override
	public List<Comisaria> readByDistrito(String distrito) throws Exception {
		return comisariaRepository.findByDistrito(distrito);
	}

}
