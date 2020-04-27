package pe.edu.upc.oneweb.model.repository;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T, ID> {
	Integer insert(T t) throws Exception;
	Integer update(T t) throws Exception;
	Integer delete(T t) throws Exception;
	List<T> findAll() throws Exception;
	Optional<T> findById(ID id) throws Exception;
}
