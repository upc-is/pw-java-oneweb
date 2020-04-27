package pe.edu.upc.oneweb.model.repository;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.oneweb.model.entity.Detenido;

public interface DetenidoRepository extends JpaRepository<Detenido, Integer> {	
	Optional<Detenido> findByDni(String dni) throws Exception;
	List<Detenido> findByApellidos( String apellidos ) throws Exception;
}
