package app.foundation.persistence.impl;

import foundation.persistence.CustomerDao;
import foundation.persistence.objects.Customer;
import javax.ejb.Stateless;

@Stateless
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

    @Override
    protected Boolean isPersistent(Customer t) {
        return !(t.getId() == null);
    }

}
