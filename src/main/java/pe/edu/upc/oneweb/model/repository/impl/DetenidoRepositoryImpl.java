package pe.edu.upc.oneweb.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.oneweb.model.entity.Detenido;
import pe.edu.upc.oneweb.model.repository.DetenidoRepository;

@Named
public class DetenidoRepositoryImpl implements DetenidoRepository, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "onewebPU")
	private EntityManager em;

	@Override
	public Integer insert(Detenido t) throws Exception {
		// 
		em.persist(t);		
		return t.getId();
	}

	@Override
	public Integer update(Detenido t) throws Exception {
		// 
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer delete(Detenido t) throws Exception {
		// 
		em.remove(t);		
		return t.getId();
	}

	@Override
	public List<Detenido> findAll() throws Exception {
		// 
		List<Detenido> detenidos = new ArrayList<>();
		// Elaborando la sentencia JPQL 
		TypedQuery<Detenido> query = em.createQuery("SELECT d FROM Detenido AS d", Detenido.class);
		// Ejecuta el query y devuelve el resultado del query
		detenidos = query.getResultList();
		return detenidos;
	}

	@Override
	public Detenido findById(Integer id) throws Exception {
		// 
		List<Detenido> detenidos = new ArrayList<>();
		
		// Elaborando la sentencia JPQL
		// Opción 1: utilizando el setParameter
		TypedQuery<Detenido> query = em.createQuery("SELECT d FROM Detenido d WHERE d.id = ?1", Detenido.class);
		query.setParameter(1, id);
		// Opción 2: Cuando el valor a buscar esta en una variable
		// TypedQuery<Detenido> query = em.createQuery("SELECT d FROM Detenido d WHERE d.id = :id)", Detenido.class);
		
		// Ejecuta el query y devuelve el resultado del query
		detenidos = query.getResultList();
		
		if( detenidos == null || detenidos.isEmpty() )
			return new Detenido();	// return null;
		else
			return detenidos.get(0);
	}

	@Override
	public Detenido findByDni(String dni) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Detenido> findByApellidos(String apellidos) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
