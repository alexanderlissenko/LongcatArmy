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
    private Long id;
    private String name;
    private Double price;
    private String info;
    private Date expire;
    private Double tmpPrice;
    
    private AuctionObject tmpobj;
    
    @Inject
    private void setSite(SuperSiteBean site){
        this.site = site;
        setAuctionObject(id);
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
    
    
    public AuctionObject setAuctionObject(Long id) {
        
        AuctionObject obj = site.getAuctionCatalogue().find(id);
        this.id = obj.getId();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.info = obj.getInfo();
        this.expire = obj.getExpire();
        return obj;
    }
    
    

    public Long getId() {
        return tmpobj.getId();
    }

    public void setId(Long id) {
        //this.id = id;
    }
    
    public String getName(){
        return tmpobj.getName();
    }
    
    public String getInfo(){
        return tmpobj.getInfo();
    }
    
    public Double getPrice(){
        return tmpobj.getPrice();
    }
    
    public Date getExpire(){
        return tmpobj.getExpire();
    }
    
    public void setBid(){
        //skicka till nåt coolt i src, controller??
        if(price > tmpPrice){
            AuctionObject obj = new AuctionObject(id,name,info,price,expire);
            site.getAuctionCatalogue().update(obj);
        }
    }
    
    
    
}