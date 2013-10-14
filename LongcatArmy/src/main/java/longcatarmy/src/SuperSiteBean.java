/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import longcat.auction.src.AuctionFactory;
import longcat.auction.src.SuperSiteOld;
import longcat.auction.src.SuperSiteOld;

/**
 *
 * @author k02sthe
 */
@ApplicationScoped
@Named("supersite")
public class SuperSiteBean extends SuperSiteOld implements Serializable{
    
    
    
    private SuperSiteBean() {
        
    }
    
    @PostConstruct
    public void post()
    { 
        initTestData();
    }
    /*public SuperSite setSite(){
        
        return fac.getAuction(true);
    }*/
}
