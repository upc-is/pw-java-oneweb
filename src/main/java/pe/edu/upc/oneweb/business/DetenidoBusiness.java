package pe.edu.upc.oneweb.business;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.oneweb.model.entity.Detenido;

public interface DetenidoBusiness extends CrudBusiness<Detenido, Integer> {
	Optional<Detenido> readByDni(String dni) throws Exception;
	List<Detenido> readByApellidos( String apellidos ) throws Exception;
}
