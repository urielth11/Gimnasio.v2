package pe.cibertec.dao.spec;

import java.util.List;

public interface CrudDAO<T,I> {
	public void save(T bean);
	public void update(T bean);
	public void delete(I id);
	public void saveUpdate(T bean);
	public List<T> listAll();
	public T findById(I id);
}
