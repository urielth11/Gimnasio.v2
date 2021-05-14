package pe.cibertec.service.spec;

import java.util.List;

public interface CrudService<T,I> {
	public void save(T bean);
	public void update(T bean);
	public void delete(I id);
	public void saveUpdate(T bean);
	public List<T> listAll();
	public T findById(I id);
}
