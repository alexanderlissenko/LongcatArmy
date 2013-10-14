/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import longcat.auction.src.SuperSite;



/**
 *
 * @author k02sthe
 */
@ApplicationScoped
public class SuperSiteBean extends SuperSite implements Serializable{
    
    SuperSiteBean() {
        
    }
    
    @PostConstruct
    public void post()
    { 
        initTestData();
    }
}
