/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;
import longcat.auction.src.SuperSite;

/**
 *Just nu bara en kopia av AuctionCatalogue, ska fixas??
 * @author Alexander Lissenko
 */

@SessionScoped
public class AuctionCatalogueBean implements Serializable{
    SuperSite site;
    ArrayList<Customer> customers;
    HashMap<Customer, List<AuctionObject>> auctionMap;
    Boolean validBid;
    Customer seller;
    
    public AuctionCatalogueBean(SuperSite site) {
        //super(AuctionObject.class,puName);
        this.site = site;
       
    }
    
    public void initiate(){
        customers =  null;//site.getCustomerCatalogue().getCustomers();
        auctionMap = null;//site.getCustomerCatalogue().getAuctionMap();
    }
    
    public void newAuction(Customer cust,AuctionObject obj)
    {   
        initiate();
        if(cust.getAccess()){ 
            customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
            auctionMap.get(cust).add(obj);
      
        }
    }
    
    public void removeAuction(Customer cust,AuctionObject obj,Boolean sold){
        initiate();
        customers.get(customers.indexOf(cust)).removeMySellAuctionList(obj, sold); 
        auctionMap.get(cust).remove(obj);
    }
    
    public void updateAuction(Customer cust, AuctionObject obj){
        initiate();
        removeAuction(cust,obj,false); //fasle because it is not sold here
        newAuction(cust,obj);
    }
        
    public List<AuctionObject> getAllAuctions()
    {
        initiate();
        ArrayList allList = new ArrayList();
        for(List<AuctionObject> value: auctionMap.values())
        {
            for(AuctionObject obj: value)
                allList.add(obj);
        }
        return allList;
    }
    
    /* public void doBid(Customer cust, Double price, AuctionObject obj){ //Ska vi använda denna?
        initiate();
        validBid = obj.setBid(cust, price); 

        if(validBid){
            customers.get(customers.indexOf(cust)).addMyBuyAuctionList(obj);
        }
        
    }
     
     public void soldObject(AuctionObject obj, Double price){
        initiate();
        //Remove from buyer buyList
        for ( HashMap<Customer, Double> o : obj.getBidder()){     
            for ( Map.Entry<Customer, Double> p:o.entrySet()){
                if (price.equals(p.getValue())){  
                    p.getKey().removeMyBuyAuctionList(obj);
                    System.out.println("object is sold"); 
                }
            }
        }
        
        //Remove from sellers sellList
        for (Map.Entry<Customer, List<AuctionObject>> s: auctionMap.entrySet()){
            for (AuctionObject ao : s.getValue()){
                if (obj.equals(ao)){
                    seller = s.getKey();                    
                    System.out.println("Right object");
                }
            }                       
        }
        removeAuction(seller,obj ,true);;
    }*/
}
