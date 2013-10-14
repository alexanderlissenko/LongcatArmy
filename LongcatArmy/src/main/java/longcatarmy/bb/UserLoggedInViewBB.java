/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import longcatarmy.src.SuperSiteBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

/**
 *
 * @author William Axhav Bratt
 */

@SessionScoped
@Named("userLIV") //UserLoggedInView
public class UserLoggedInViewBB implements Serializable {
    
    private List<AuctionObject> expAuctions;
    //private AuctionBB test = AuctionBB.INSTANCE;
    Customer testCust;
    
    @Inject
    SuperSiteBean site;
    
    public UserLoggedInViewBB()
    {
        
        
   
    }
    
    @PostConstruct
    public void post()
    {
        testCust = site.getCustomerCatalogue().getCustomerByName("apa");

        expAuctions = site.getCustomerCatalogue().getAllAuctionsForUser(testCust);
    }
    
    public List<AuctionObject> getAuctions()
    {
        return expAuctions;
    }
    
    public List<AuctionObject> getBids()
    {
        return testCust.getMyBuyAuctionList();
    }
    
}
