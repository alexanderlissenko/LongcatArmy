/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import longcatarmy.src.AuctionFactory;
import longcatarmy.src.AuctionObject;
import longcatarmy.src.Customer;
import longcatarmy.src.SuperSite;

/**
 *
 * @author William Axhav Bratt
 */

@SessionScoped
@Named("userLIV") //UserLoggedInView
public class UserLoggedInViewBB implements Serializable {
    
    private List<AuctionObject> expAuctions;
    private SuperSite site = AuctionFactory.getAuction(true);
    
    @PostConstruct
    public void post()
    {
        
        Customer testUI = site.getCustomerByName("apa");
        
        expAuctions = site.getAllAuctionsForUser(testUI);
    }
    
    public List<AuctionObject> getAuctions()
    {
        return expAuctions;
    }
    
}
