/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Singleton;
import longcat.auction.src.SuperSite;



/**
 * Singleton wrapper for SuperSite
 * @author Henrik Ståhlsparre
 */
@ApplicationScoped
@Singleton
public class SuperSiteBean extends SuperSite implements Serializable{
    
    SuperSiteBean() {
        
    }
    
    @PostConstruct
    public void post() { 
        initTestData();
    }
}
