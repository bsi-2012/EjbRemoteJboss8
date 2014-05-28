package foundation.persistence;

import foundation.persistence.objects.Customer;
import javax.ejb.Remote;

@Remote
public interface CustomerDaoRemote extends GenericDao<Customer> {

    public String hello();
    public Customer create();

}
