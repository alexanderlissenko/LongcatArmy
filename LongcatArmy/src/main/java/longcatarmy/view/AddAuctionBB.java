/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.view;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;
import longcatarmy.src.SuperSiteBean;

/**
 * Backing bean for Add Auction View
 * @author William Axhav Bratt
 */
@ConversationScoped //wont work with other scopes
@Named("addAuction")
public class AddAuctionBB implements Serializable{
    
    Customer cust;
    String name;
    double price;
    String info;
    String imgLink;
    
    @Inject
    SuperSiteBean site;
    
    public AddAuctionBB(){
    }
    
    @PostConstruct
    public void post(){ 
        cust = site.getCustomerCatalogue().find(Long.parseLong("1"));
    }
    
    
    public String actOnSelected(){
        if(imgLink.equals("")){
            site.createNewAuction(cust,new AuctionObject(name,info,price,new Date()));
        }
        else{
            site.createNewAuction(cust,new AuctionObject(name,info,price,new Date()),imgLink);
        }
        return "success";
    }  
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setLink(String link){
        this.imgLink = link;
    }
    
    public String getLink(){
        return imgLink;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setInfo(String info){
        this.info = info;
    }
    
    public String getInfo(){
        return info;
    }
   
}
