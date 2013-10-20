/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import longcat.auction.src.Customer;

/**
 * Resource for Customer catalogue
 * @author Alexander Lissenko
 */

@Path("customers")
public class CustomerCatalogueResource {
    
    private final static Site site = Site.INSTANCE;
    
    private UriInfo uriInfo;
    
    @GET
    @Path("/count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getCount() {
        int c = site.getCustomerCatalogue().getCount();
        PrimitiveJSONWrapper<Integer> wc = new PrimitiveJSONWrapper<Integer>(c);
        return Response.ok(wc).build();
    }
    
    @GET
    @Path("/range") 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getRange( @QueryParam("first") String first, 
                                    @QueryParam ("last")String last) {
        List<Customer> cl = site.getCustomerCatalogue().getRange(Integer.parseInt(first), Integer.parseInt(last));
        List<CustomerProxy> proxList = new ArrayList<CustomerProxy>();
        for(Customer c: cl) {
            CustomerProxy cp = new CustomerProxy(c);
            proxList.add(cp);
        }
        GenericEntity<List<CustomerProxy>> ge = new GenericEntity<List<CustomerProxy>>(proxList){};
        return Response.ok(ge).build();
    }
    
    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response update(@PathParam("id") Long id, @FormParam ("email") String email,
            @FormParam ("name") String name, @FormParam ("password") String password,
            @FormParam ("phoneNr") String phoneNr, @FormParam("seqQuest") String seqQuest, 
            @FormParam("address") String address){
        try {
            Customer cust = site.getCustomerCatalogue().find(id);
            cust.setEmail(email);
            cust.setName(name);
            cust.setPassword(password);
            cust.setPhoneNr(phoneNr);
            cust.setSeqQuest(seqQuest);
            cust.setAddress(address);
            site.getCustomerCatalogue().update(cust);
            CustomerProxy cx = new CustomerProxy(cust);
            return Response.ok(cx).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam ("id") Long id){
        try {
            site.getCustomerCatalogue().remove(id);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
