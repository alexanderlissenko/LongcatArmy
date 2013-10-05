/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import javax.inject.Named;
import javax.inject.Singleton;
import longcatarmy.src.AuctionFactory;
import longcatarmy.src.SuperSite;

/**
 *
 * @author Emelie Svensson
 */
@Singleton
@Named("auction")
public class AuctionBB {
    private final SuperSite auction; 
    
    public AuctionBB(){
        auction = AuctionFactory.getAuction(true);
    }
    
}
