package pe.edu.upc.oneweb.business;

import java.util.List;

import pe.edu.upc.oneweb.model.entity.Comisaria;

public interface ComisariaBusiness extends CrudBusiness<Comisaria, Integer> {
	List<Comisaria> readByDistrito( String distrito ) throws Exception;
}
