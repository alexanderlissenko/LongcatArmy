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
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

/**
 *
 * @author Alexander Lissenko
 */

@Path("admin")
public class AdminResource {
    
    private final static Site site = Site.INSTANCE;
    
    private UriInfo uriInfo;
    
    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public String doTest() {
        return "Hello";
    }
    
    @GET
    @Path("customer/" + "{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCustomerCount() {
        int c = site.getCustomerCatalogue().getCount();//Long site.getCustomerCount(); 
        PrimitiveJSONWrapper<Integer> wc = new PrimitiveJSONWrapper<Integer>(c);
        return Response.ok(wc).build();
    }
    
    @GET
    @Path("auctionObject/" + "{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAuctionCount() {
        int a = site.getAuctionCatalogue().getCount();//Long site.getCustomerCount(); 
        PrimitiveJSONWrapper<Integer> wa = new PrimitiveJSONWrapper<Integer>(a);
        return Response.ok(wa).build();
    }
    
    @GET
    @Path("/rangeA") 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getRangeA( @QueryParam("first") String first, 
                                    @QueryParam ("nItems")String nItems) {
        //status ok
        //List<T> --> generic 
        List<AuctionObject> al = site.getAuctionCatalogue().getRange(Integer.parseInt(first), Integer.parseInt(nItems));
        List<AuctionProxy> proxList = new ArrayList<AuctionProxy>();
        for(AuctionObject a: al) {
            AuctionProxy ap = new AuctionProxy(a);
            proxList.add(ap);
        }
        GenericEntity<List<AuctionProxy>> ge = new GenericEntity<List<AuctionProxy>>(proxList){};
        return Response.ok(ge).build();
        
    }
    
    @GET
    @Path("/rangeC") 
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getRangeC( @QueryParam("first") String first, 
                                    @QueryParam ("nItems")String nItems) {
        //status ok
        //List<T> --> generic 
        List<Customer> cl = site.getCustomerCatalogue().getRange(Integer.parseInt(first), Integer.parseInt(nItems));
        List<CustomerProxy> proxList = new ArrayList<CustomerProxy>();
        for(Customer c: cl) {
            CustomerProxy cp = new CustomerProxy(c);
            proxList.add(cp);
        }
        GenericEntity<List<CustomerProxy>> ge = new GenericEntity<List<CustomerProxy>>(proxList){};
        return Response.ok(ge).build();
        
    }
    
    @PUT
    @Path("customer/" + "{id}") //funkar detta??
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response editCustomer(@FormParam ("email") String email,
            @FormParam ("name") String name, @FormParam ("pass") String pass,
            @FormParam ("phone") String phone, @FormParam("seQuest") String seQuest, 
            @FormParam("address") String address, @FormParam("access") Boolean access){
        try {
            Customer newCust = new Customer(email,name,pass,phone,seQuest,address);
            site.getCustomerCatalogue().update(newCust);
            CustomerProxy cx = new CustomerProxy(newCust);
            return Response.ok(cx).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("customer" + "{id}") //funkar detta???
    public Response deleteCustomer(@PathParam ("id") Long id){
        try {
            site.getCustomerCatalogue().remove(id);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("auctionObject" + "{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response editAuction(@FormParam("title") String title, 
            @FormParam("info") String info, @FormParam("price") Double price) {
        try {
            AuctionObject obj = new AuctionObject(title, info, price);
            //AuctionObject obj = new AuctionObject(title, info, price);
            site.getAuctionCatalogue().update(obj);
            AuctionProxy ax = new AuctionProxy(obj);
            return Response.ok(ax).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("auctionObject" + "{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteAuction(@PathParam("id") Long id) {
        try {
            site.getAuctionCatalogue().remove(id);
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
