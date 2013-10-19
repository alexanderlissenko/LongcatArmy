/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.view;

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
    Long id;
    
    @Inject
    SuperSiteBean site;
    
    public UserLoggedInViewBB()
    {
        
    }
    
    @PostConstruct
    public void post()
    {
        
    }
    
    public List<AuctionObject> getAuctions()
    {
        testCust = site.getCustomerCatalogue().find(Long.parseLong("1"));//site.getCustomerCatalogue().getByName("apa").get(0);
        expAuctions = testCust.getMySellAuctionList();
        return expAuctions;
    }
    
    public List<AuctionObject> getBids()
    {
        //List<Customer> foundy =site.getCustomerCatalogue().getByName("apa");
        //testCust = foundy.get(0);
        testCust = site.getCustomerCatalogue().find(Long.parseLong("1"));//site.getCustomerCatalogue().getByName("apa").get(0);
        expAuctions = site.getCustomerCatalogue().getAllAuctionsForUser(testCust);
        return testCust.getMyBuyAuctionList();
    }
    
    public String goToAuction(Long id) {
        this.id = id;
        //return "success?faces-redirect=true&includeViewParams=true"; //ev bara return success
        return "success";
    }
    
}
