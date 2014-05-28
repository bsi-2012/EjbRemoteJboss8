package foundation.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public interface GenericDao<T> {

    public T save(T record);

    public Boolean remove(Long id);

    public List<T> findAll();

    public T findById(Long id);

    public T findByName(String name);

    default public Class<T> getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
