package pe.edu.upc.oneweb.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.oneweb.model.entity.Multa;
import pe.edu.upc.oneweb.model.repository.MultaRepository;

@Named
public class MultaRepositoryImpl implements MultaRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "onewebPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Multa t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Multa t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Multa t) throws Exception {
		em.remove(t);
		return t.getId();
	}

	@Override
	public List<Multa> findAll() throws Exception {
		List<Multa> multas = new ArrayList<>();
		
		TypedQuery<Multa> query = em.createQuery("SELECT m FROM Multa m", Multa.class);
		multas = query.getResultList();
		
		return multas;
	}

	@Override
	public Optional<Multa> findById(Integer id) throws Exception {
		List<Multa> multas = new ArrayList<>();
		
		TypedQuery<Multa> query = em.createQuery("SELECT m FROM Multa m WHERE m.id = ?1", Multa.class);
		query.setParameter(1, id);
		multas = query.getResultList();
		
		if( multas == null || multas.isEmpty() )
			return Optional.empty();
		else
			return Optional.of( multas.get(0) );
	}

}
