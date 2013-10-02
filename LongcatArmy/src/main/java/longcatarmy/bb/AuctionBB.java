/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import javax.inject.Named;
import javax.inject.Singleton;
import longcatarmy.src.IAuction;

/**
 *
 * @author emesven
 */
@Singleton
@Named("auction")
public class AuctionBB {
    private final IAuction auction;
    
    public AuctionBB(){
        auction = AuctionFactory.getAuction(true); //inte implementerad ännu
    }
    
}
