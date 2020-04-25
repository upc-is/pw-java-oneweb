package pe.edu.upc.oneweb.model.repository;

import java.util.List;

import pe.edu.upc.oneweb.model.entity.Comisaria;

public interface ComisariaRepository extends JpaRepository<Comisaria, Integer> {
	List<Comisaria> findByDistrito( String distrito ) throws Exception;
}
