package pe.edu.upc.oneweb.model.repository;

import pe.edu.upc.oneweb.model.entity.Detenido;

public interface DetenidoRepository extends JpaRepository<Detenido, Integer> {	
	Detenido findByDni(String dni) throws Exception;
}
