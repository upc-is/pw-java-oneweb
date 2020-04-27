package pe.edu.upc.oneweb.model.repository;

import java.util.List;

import pe.edu.upc.oneweb.model.entity.Detenido;

public interface DetenidoRepository extends JpaRepository<Detenido, Integer> {	
	Detenido findByDni(String dni) throws Exception;
	List<Detenido> findByApellidos( String apellidos ) throws Exception;
}
