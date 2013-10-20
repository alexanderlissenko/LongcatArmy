/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.List;
import javax.inject.Inject;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

/**
 * Controller class
 * @author emesven
 */
public class Controller {
    @Inject
    SuperSiteBean site;
    List<Customer> customers;
    
    public Controller(){
    }
    
    public void initiate(){
        customers = site.getCustomerCatalogue().getRange(0, site.getCustomerCatalogue().getCount());
    }
    
    public void newAuction(Customer cust,AuctionObject obj){   
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
        removeAuction(cust,obj,false); //false because it is not sold here
        newAuction(cust,obj);
    }
    
    
    
    /************ Customer functionality***********************
     * 
     */  
    public void banCustomer(Customer cust){
        cust.setAccess(false);
        cust.emptyMyLists(); 
    }
}
