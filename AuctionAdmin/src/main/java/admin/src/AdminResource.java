/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    
    //instansiering av SuperSite eller Control här!!!
    
    AuctionProxy auctions;
    CustomerProxy customers;
    private UriInfo uriInfo;
    
    @PUT
    @Path("{customer.id}") //funkar detta??
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response editCustomer(@FormParam ("email") String email,
            @FormParam ("name") String name, @FormParam ("pass") String pass,
            @FormParam ("phone") String phone, @FormParam("seQuest") String seQuest, 
            @FormParam("address") String address, @FormParam("access") Boolean access){
        Customer newCust;
        //TODO******************************************************
        //här ska nåt site.updateCustomer eller liknande in
        //glöm ej wrappa om till proxy
        return Response.ok().build(); //fixas sen
    }
    
    @DELETE
    @Path("{customer.id}") //funkar detta???
    public Response deleteCustomer(@PathParam ("id") Long id){
        try {
            //site.getCustomerCatalogue().remove(id) eller liknande
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{auctionObject.id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response editAuction(@FormParam("title") String title, 
            @FormParam("info") String info, @FormParam("price") Double price) {
        AuctionObject obj;
        //TODO******************************************************
        //här ska nåt site.updateAuction eller liknande in
        //glöm ej wrappa om till proxy
        return Response.ok().build(); //fixas sen
    }
    
    @DELETE
    @Path("{auctionObject.id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteAuction(@PathParam("id") Long id) {
        try {
            //site.getAuctionCatalogue().remove(id) eller liknande
            return Response.ok().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    
}
