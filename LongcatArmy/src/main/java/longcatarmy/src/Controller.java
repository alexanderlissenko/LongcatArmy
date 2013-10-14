/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

/**
 *
 * @author emesven
 */
public class Controller {
    @Inject
    SuperSiteBean site;
    ArrayList<Customer> customers;
    //HashMap<Customer, List<AuctionObject>> auctionMap;
    
    public Controller(){
        
    }
    public void initiate(){
        customers = site.getCustomerCatalogue().getCustomers();
        //auctionMap = site.getCustomerCatalogue().getAuctionMap();
    }
    public void newAuction(Customer cust,AuctionObject obj)
    {   
        initiate();
        if(cust.getAccess()){ 
            site.getAuctionCatalogue().add(obj);
            customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
      
        }
    }
    
    public void removeAuction(Customer cust,AuctionObject obj,Boolean sold){
        initiate();
        site.getAuctionCatalogue().remove(obj.getId());
        customers.get(customers.indexOf(cust)).removeMySellAuctionList(obj, sold); 
    }
    
    public void updateAuction(Customer cust, AuctionObject obj){
        initiate();
        removeAuction(cust,obj,false); //fasle because it is not sold here
        newAuction(cust,obj);
    }
    
    public List<AuctionObject> getAllAuctions()
    {
        initiate();
        return site.getAuctionCatalogue().getRange(0, site.getAuctionCatalogue().getCount());
    }
    
    public void doBid(Customer cust, Double price, AuctionObject obj){ //Ska vi använda denna?
        initiate();

        if(price > obj.getPrice()){
            obj.setPrice(price);
            site.getAuctionCatalogue().update(obj);
        }
        
    }
    
    /************ Customer functionality***********************
     * 
     * 
     */
    
    public List<AuctionObject> getAllAuctionsForUser(Customer cust)
    {
        return site.getCustomerCatalogue().find(cust.getId());
    }
    
    public void banCustomer(Customer cust){
        cust.setAccess(false);
        cust.emptyMyLists(); 
        
        // tabort för andra användare
        
    }
    
}
