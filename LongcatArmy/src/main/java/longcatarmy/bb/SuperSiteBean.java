/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import longcatarmy.src.AuctionFactory;
import longcatarmy.src.SuperSite;

/**
 *
 * @author k02sthe
 */
@ApplicationScoped
@Named("supersite")
public class SuperSiteBean extends SuperSite implements Serializable{
    
    
    
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
