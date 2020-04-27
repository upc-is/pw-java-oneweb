package pe.edu.upc.oneweb.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.oneweb.model.entity.Comisaria;
import pe.edu.upc.oneweb.model.repository.ComisariaRepository;

@Named
public class ComisariaRepositoryImpl implements ComisariaRepository, Serializable{
	
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "onewebPU")
	private EntityManager em;
	
	@Override
	public Integer insert(Comisaria t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer update(Comisaria t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Comisaria t) throws Exception {
		em.remove(t);
		return t.getId();
	}

	@Override
	public List<Comisaria> findAll() throws Exception {
		List<Comisaria> comisarias = new ArrayList<>();
		
		TypedQuery<Comisaria> query = em.createQuery("SELECT c FROM Comisaria AS c", Comisaria.class);
		comisarias = query.getResultList();
		
		return comisarias;
	}

	@Override
	public Optional<Comisaria> findById(Integer id) throws Exception {
		List<Comisaria> comisarias = new ArrayList<>();
		
		TypedQuery<Comisaria> query = em.createQuery("SELECT c FROM Comisaria c WHERE c.id = ?1", Comisaria.class);
		query.setParameter(1, id);
		comisarias = query.getResultList();
		
		if(comisarias == null || comisarias.isEmpty())
			return Optional.empty();
		else	
			return Optional.of( comisarias.get(0) );
	}

	@Override
	public List<Comisaria> findByDistrito(String distrito) throws Exception {
		List<Comisaria> comisarias = new ArrayList<>();
		
		TypedQuery<Comisaria> query = em.createQuery("SELECT c FROM Comisaria c WHERE c.distrito LIKE ?1", Comisaria.class);
		query.setParameter(1, "%" + distrito + "%");
		comisarias = query.getResultList();
		
		return comisarias;
	}

}





