/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import longcatarmy.src.SuperSiteBean;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.AuctionObject;

/**
 *
 * @author Alexander Lissenko
 */

@RequestScoped
@Named("viewAuction")
public class ViewAuctionBB implements Serializable {
    
    
    private SuperSiteBean site;
    private Long auctionId;
    private Long homeId;
    private String name;
    private Double price;
    private String info;
    private Date expire;
    private Double tmpPrice;
    
    private AuctionObject tmpobj;
    
    @Inject
    private void setSite(SuperSiteBean site){
        this.site = site;
        
    }
    
    //AuctionObject obj;
    //Long id; //****************************************OBS! bort med denna när id skickas med
    
    public ViewAuctionBB(){
        
    }
    
    @PostConstruct
    public void post(){
        tmpPrice = price;
        //tmpobj = site.getAuctionCatalogue().find(id);
    }
    
    
    public void setAuctionObject(Long id) {
        homeId = id;
        
        this.tmpobj = site.getAuctionCatalogue().find(homeId);
        auctionId = tmpobj.getId();
        this.name = tmpobj.getName();
        this.price = tmpobj.getPrice();
        this.info = tmpobj.getInfo();
        this.expire = tmpobj.getExpire();

    }
    
    

    public Long getId() {
        //tmpobj = setAuctionObject(homeId);
        return tmpobj.getId();
    }

    public void setId(Long id) {
        //this.id = id;
    }
    
    public String getName(){
        //tmpobj = setAuctionObject(homeId);
        return tmpobj.getName();
    }
    
    public String getInfo(){
        //tmpobj = setAuctionObject(homeId);
        return tmpobj.getInfo();
    }
    
    public Double getPrice(){
        //tmpobj = setAuctionObject(homeId);
        return tmpobj.getPrice();
    }
    
    public Date getExpire(){
        //tmpobj = setAuctionObject(homeId);
        return tmpobj.getExpire();
    }
    
    public void setBid(){
        //tmpobj = setAuctionObject(homeId); //******************************************eventuellt ta bort
        //skicka till nåt coolt i src, controller??
        if(price > tmpPrice){
            AuctionObject obj = new AuctionObject(homeId,name,info,price,expire);
            site.getAuctionCatalogue().update(obj);
        }
    }
    
    
    
}