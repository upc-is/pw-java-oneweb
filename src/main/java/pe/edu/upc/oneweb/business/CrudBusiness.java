package pe.edu.upc.oneweb.business;

import java.util.List;
import java.util.Optional;

// Equivalente a las Capa Service de Spring

public interface CrudBusiness<T, ID> {
	Integer create(T t) throws Exception;
	Integer update(T t) throws Exception;
	Integer delete(T t) throws Exception;
	List<T> readAll() throws Exception;
	Optional<T> readById(ID id) throws Exception;
}
