package consumerfoundation;

import foundation.persistence.CustomerDaoRemote;
import foundation.persistence.objects.Customer;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ConsumerFoundation {

    static String JNDI_NAME = 
            "ejb:EnterpriseFoundation/EnterpriseFoundation-ejb/CustomerDaoRemoteImpl!foundation.persistence.CustomerDaoRemote";
    
     public static void main(String... args) throws Exception {
         try {
             
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            final Context context = new InitialContext(jndiProperties);
            CustomerDaoRemote customerDaoRemote = (CustomerDaoRemote) context.lookup(JNDI_NAME);  

            
             for(Customer cust : customerDaoRemote.findAll()) {
                 System.out.println("Id: " + cust.getId() + " Name: " + cust.getName());
             }
             
             customerDaoRemote.remove(customerDaoRemote.findByName("Teste").getId());
                          
             System.out.println("\nUsuarios");
             customerDaoRemote.findAll().forEach(e -> {
                 System.out.println("Id: " + e.getId() + " Name: " + e.getName());
             });
             
             
             context.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
             e.printStackTrace();
        }
     }

}
