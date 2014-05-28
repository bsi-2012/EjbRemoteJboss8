package foundation.persistence;

import foundation.persistence.objects.Customer;
import javax.ejb.Local;

@Local
public interface CustomerDao extends GenericDao<Customer> {
}
