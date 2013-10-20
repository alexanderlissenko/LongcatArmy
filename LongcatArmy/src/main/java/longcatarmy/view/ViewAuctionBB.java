/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.view;

import longcatarmy.src.SuperSiteBean;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.SessionScoped;  
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

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
    private String img;
    
    
    
    public ViewAuctionBB(){
        
    }

    public void setAuction() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String idString = fc.getExternalContext().getRequestParameterMap().get("id");
        AuctionObject ao = site.getAuctionCatalogue().find(Long.parseLong(idString));
        name=ao.getName();
        price=ao.getPrice();
        info=ao.getInfo();
        expire=ao.getExpire();
    }

    public Long getId() {
        
        return getIdParam();
    }

    public void setId(Long id) {
        this.id = (id);
    }
    
    public Long getIdParam()
    {
        FacesContext fc = FacesContext.getCurrentInstance();
        String idString = fc.getExternalContext().getRequestParameterMap().get("id");
        return Long.parseLong(idString);
    }
    
    public String getName(){
        
         
        return site.getAuctionCatalogue().find(getIdParam()).getName();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getInfo(){
        return site.getAuctionCatalogue().find(getIdParam()).getInfo();
    }
    
    public void setInfo(String info){
        this.info = info;
        
    }
    
    public Double getPrice(){
        return site.getAuctionCatalogue().find(getIdParam()).getPrice();
    }
    
    public void setPrice(Double price){
        this.price = price;
        
    }
    
    public Date getExpire(){
        return site.getAuctionCatalogue().find(getIdParam()).getExpire();
    }
    
    public void setExpire(Date expire){
        this.expire = expire;
        
    }
    
    public String getImg(){
        return site.getAuctionCatalogue().find(getIdParam()).getLink();
    }
    
    public void setImg(String img){
        this.img = img;
        
    }
    
    public String onSetBid() {
        final AuctionObject auctionObject = site.getAuctionCatalogue().find(id);
        Customer cust = site.getCustomerCatalogue().find(Long.parseLong("1"));
        site.doBid(cust, price, auctionObject);
        //FacesContext.getCurrentInstance().addMessage(null, null);
        
        return "user";
    }
}