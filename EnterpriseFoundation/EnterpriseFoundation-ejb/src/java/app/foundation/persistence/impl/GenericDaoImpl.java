package app.foundation.persistence.impl;

import foundation.persistence.GenericDao;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@PermitAll
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext(unitName = "EnterpriseFoundation-ejbPU")
    private EntityManager entityManager;

    @Override
    public T save(T record) {
        if(isPersistent(record)) {
            record = entityManager.merge(record);
        }else{
            entityManager.persist(record);
        }
        return record;
    }

    @Override
    public Boolean remove(Long id) {
        try {
            T record = this.findById(id);
            entityManager.remove(record);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("SELECT c FROM Customer c").getResultList();
    }

    @Override
    public T findById(Long id) {
        return (T) entityManager.createQuery("SELECT c FROM Customer c WHERE c.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public T findByName(String name) {
        return (T) entityManager.createQuery("SELECT c FROM Customer c WHERE c.name = :id")
                .setParameter("id", name).getSingleResult();
    }

    protected abstract Boolean isPersistent(T t);

}
