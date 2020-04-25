package pe.edu.upc.oneweb.model.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.oneweb.model.entity.Detenido;
import pe.edu.upc.oneweb.model.repository.DetenidoRepository;

@Named
public class DetenidoRepositoryImpl implements DetenidoRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "onewebPU")
	private EntityManager em;

	@Override
	public Integer insert(Detenido t) throws Exception {
		// TODO Auto-generated method stub
		em.persist(t);		
		return t.getId();
	}

	@Override
	public Integer update(Detenido t) throws Exception {
		// TODO Auto-generated method stub
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Detenido t) throws Exception {
		// TODO Auto-generated method stub
		em.remove(t);		
		return t.getId();
	}

	@Override
	public List<Detenido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detenido findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Detenido findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
