/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcatarmy.src.AuctionObject;
import longcatarmy.src.SuperSite;

/**
 *
 * @author William Axhav Bratt
 */
@RequestScoped
@Named("home")
public class HomeBB implements Serializable{
    
    
    @Inject
    SuperSiteBean site;
    
    
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
