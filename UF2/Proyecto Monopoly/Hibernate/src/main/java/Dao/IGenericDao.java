package Dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T, ID extends Serializable> {
	// en Save o Update debes pasarle el mismo tipo que el Generico que has especificado
	void saveOrUpdate(T entity);

	// get devuelve el generico especificado
	T get(ID id);

	//delete le pasas la id
	void delete(ID id);
	
	//delete le pasas la entidad
	void delete(T entity);

	//puedes especificar que devuelva una lista de genericos
	List<T> list();

}
