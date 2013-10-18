/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.view;

import longcatarmy.src.SuperSiteBean;
import java.io.Serializable;
import java.util.Date;
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
    private Long id;
    private String name;
    private Double price;
    private String info;
    private Date expire;
    private Double tmpPrice;
    
    
    public ViewAuctionBB(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(Long id){
        this.name = site.getAuctionCatalogue().find(this.id).getName();
        
    }
    
    public String getInfo(){
        return info;
    }
    
    public void setInfo(Long id){
        this.info = site.getAuctionCatalogue().find(this.id).getInfo();
        
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setPrice(Long id){
        this.price = site.getAuctionCatalogue().find(this.id).getPrice();
        
    }
    
    public Date getExpire(){
        return expire;
    }
    
    public void setExpire(Long id){
        this.expire = site.getAuctionCatalogue().find(this.id).getExpire();
        
    }
}