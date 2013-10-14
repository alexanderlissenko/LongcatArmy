/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import javax.ws.rs.Path;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Alexander Lissenko
 */

@Path("admin")
public class AdminResource {
    
    //initiering av SuperSite
    
    AuctionProxy auctions;
    CustomerProxy customers;
    private UriInfo uriInfo;
    
    
    //TODO
}
