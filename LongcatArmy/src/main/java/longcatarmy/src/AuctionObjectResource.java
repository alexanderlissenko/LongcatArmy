/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Alexander Lissenko
 */

@Path("auction")    //eventuellt annan path, unik för varje auctionobject
public class AuctionObjectResource {
    
    private final static SuperSite site = SuperSite.getInstance();   //funkar när SuperSite är @Singleton
    
    AuctionObjectProxy objects;
    private UriInfo uriInfo;
    
    @GET
    @Path("title")
    public Response getTitle() {
        String t = 
    }
}
