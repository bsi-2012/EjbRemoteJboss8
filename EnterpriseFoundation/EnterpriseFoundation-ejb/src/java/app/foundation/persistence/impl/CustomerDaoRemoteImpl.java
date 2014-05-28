package app.foundation.persistence.impl;

import foundation.persistence.CustomerDaoRemote;
import foundation.persistence.objects.Customer;
import javax.annotation.security.PermitAll;
import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless
@PermitAll
@Remote(CustomerDaoRemote.class)
public class CustomerDaoRemoteImpl extends GenericDaoImpl<Customer> implements CustomerDaoRemote {

    @Override
    protected Boolean isPersistent(Customer t) {
        return !(t.getId() == null);
    }

    @Override
    public String hello() {
        return "Hello EJB";
    }

    @Override
    public Customer create() {
        Customer c = new Customer();
        c.setId(0L);
        c.setName("Temp");
        return c;
    }
    
}
