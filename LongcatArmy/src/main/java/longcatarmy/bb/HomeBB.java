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
import longcatarmy.src.SuperSite;

/**
 *
 * @author William Axhav Bratt
 */
@SessionScoped
@Named("home")
public class HomeBB implements Serializable{
    
    AuctionBB test = AuctionBB.INSTANCE;
    SuperSite site = test.createSuperSite();
    
    public HomeBB()
    {
    }
    
    @PostConstruct
    public void post()
    { 
    }
    
    public List<AuctionObject> getAllAuctions()
    {
        return site.getAllAuctions();
    }
}
