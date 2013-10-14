/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import longcatarmy.src.SuperSiteBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.AuctionObject;

/**
 *
 * @author Alexander Lissenko
 */

@SessionScoped
@Named("viewAuction")
public class ViewAuctionBB implements Serializable {
    
    @Inject
    SuperSiteBean site;
    
    AuctionObject obj;
    Long id; //****************************************OBS! bort med denna när id skickas med
    
    public ViewAuctionBB(){
        
    }
    
    @PostConstruct
    public void post(){
        //obj = site.getCustomerCatalogue().getAuction(id);
    }
    
    public String getTitle(){
        return obj.getTitle();
    }
    
    public String getInfo(){
        return obj.getInfo();
    }
    
    public Double getPrice(){
        return obj.getPrice();
    }
    
    public void setBid(Double newBid){
        //måste få referens till budande customer, byt null till det sen
        //site.getAuctionCatalogue().doBid(null, newBid, obj);
    }
    
    
    
}
