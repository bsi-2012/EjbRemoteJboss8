
package app.foundation.resources;

import foundation.persistence.CustomerDao;
import foundation.persistence.objects.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/customer")
@Stateless
public class CustomerResource {

    @EJB
    private CustomerDao customerDao;
        
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Customer> findAllCustomers() {
        return this.customerDao.findAll();
    }

    @GET
    @Path("/{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer findCustomerByName(@PathParam(value = "name") String name) {
        return this.customerDao.findByName(name);
    }
    
    @GET
    @Path("/id/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer findCustomerById(@PathParam(value = "id") Long id) {
        return this.customerDao.findById(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Customer saveCustomer(Customer customer) {
        return this.customerDao.save(customer);
    }
    
    @DELETE
    @Path("{id}")
    public Boolean removeCustomerById(@PathParam(value = "id") Long id) {
        return this.customerDao.remove(id);
    }
    
}
