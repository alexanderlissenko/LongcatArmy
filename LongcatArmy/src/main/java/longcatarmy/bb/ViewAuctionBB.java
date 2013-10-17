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
        //setAuctionObject(id);
        //tmpPrice = price;
    }
    
    //AuctionObject obj;
    //Long id; //****************************************OBS! bort med denna när id skickas med
    
    public ViewAuctionBB(){
        
    }
    
    @PostConstruct
    public void post(){
        //setAuctionObject(id);
        tmpPrice = price;
        //getAuction(id);
    }
    
    public AuctionObject getAuction(Long id){
        tmpobj = site.getAuctionCatalogue().find(id);
        return tmpobj;
    }
    
    
    /*public AuctionObject setAuctionObject(Long id) {
        
        AuctionObject obj = site.getAuctionCatalogue().find(id);
        this.id = obj.getId();
        this.name = obj.getName();
        this.price = obj.getPrice();
        this.info = obj.getInfo();
        this.expire = obj.getExpire();
        return obj;
    }*/
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getInfo(){
        return info;
    }
    
    public Double getPrice(){
        getAuction(id);
        return tmpobj.getPrice();
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Date getExpire(){
        return expire;
    }
    
    public void setBid(){
        //skicka till nåt coolt i src, controller??
        if(price > tmpPrice){
            AuctionObject obj = new AuctionObject(id,name,info,price,expire);
            site.getAuctionCatalogue().update(obj);
        }
    }
    
    
    
}