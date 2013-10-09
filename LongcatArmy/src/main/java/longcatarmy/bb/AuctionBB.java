/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.enterprise.inject.Produces;
import longcatarmy.src.AuctionFactory;
import longcatarmy.src.SuperSite;

/**
 *
 * @author Emelie Svensson
 */
@Singleton
@Default
@Named("Auction")
public enum AuctionBB {
    INSTANCE;
    
    private final SuperSite auction; 
    
    private AuctionBB(){
        auction = AuctionFactory.getAuction(true); //true = utan database "auction_pu" = med database
    }
    
    public SuperSite getSuperSite()
    {
        return auction;
    }
    
    @Produces SuperSite createSuperSite()
    {
        return auction;
    }
    
}
