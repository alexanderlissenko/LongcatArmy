/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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
@Named("profileEdit")
public class ProfileEditBB implements Serializable{
    
    AuctionBB test = AuctionBB.INSTANCE;
    SuperSite site = test.createSuperSite();
    
    public ProfileEditBB()
    {
    }
    
    @PostConstruct
    public void post()
    { 
    }
    
    public Customer getCustomer()
    {
        return site.getCustomerByName("apa");
    }
    
    public void actOnSelected()
    {
        
    }
    
    public String goToView()
    {
        return "profile";
    }
}
