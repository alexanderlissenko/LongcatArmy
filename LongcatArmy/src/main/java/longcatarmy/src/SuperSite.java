/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Singleton;



/**
 *
 * @author William Axhav Bratt, Emelie Svensson
 */

public class SuperSite {

    
    ArrayList<Customer> customers;
    HashMap<Customer, List<AuctionObject>> auctionMap;
    Boolean validBid;
    
    //ArrayList<AuctionObject> auctObj = new ArrayList<AuctionObject>();
    
    private SuperSite()
    {
        customers = new ArrayList<Customer>();
        auctionMap = new HashMap<Customer, List<AuctionObject>>();
    }
    
    private static class SuperSiteSingleton {
        private static SuperSite instance = new SuperSite();
    }
    
    public static SuperSite getInstance() {
        return SuperSite.getInstance();
    }
    
    public void newAuction(Customer cust,AuctionObject obj)
    {   
        if(cust.getAccess()){    
            customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
            auctionMap.get(cust).add(obj);   
        }
    }
    
    public void removeAuction(Customer cust,AuctionObject obj,Boolean sold){
        customers.get(customers.indexOf(cust)).removeMySellAuctionList(obj, sold); 
        auctionMap.get(cust).remove(obj);
    }
    
    public void updateAuction(Customer cust, AuctionObject obj){
        removeAuction(cust,obj,false); //fasle because it is not sold here
        newAuction(cust,obj);
    }
    
    public void addCustomer(Customer cust)
    {
        customers.add(cust);
        auctionMap.put(cust, new ArrayList<AuctionObject>());
    }
    
    public List<AuctionObject> getAllAuctionsForUser(Customer cust)
    {
        return auctionMap.get(cust);
    }
    
    public List<AuctionObject> getAllAuctions()
    {
        ArrayList allList = new ArrayList();
        for(List<AuctionObject> value: auctionMap.values())
        {
            for(AuctionObject obj: value)
                allList.add(obj);
        }
        return allList;
    }
    
    public void banCustomer(Customer cust){
        cust.setAccess(false);
        cust.emptyMyLists();
        auctionMap.get(cust).clear();
        //*****************************************************måste ta bort från andra customers BuyList... hur?********************************************'
        
    }
    
    public void doBid(Customer cust, Double price, AuctionObject obj){ //Ska vi använda denna?
        validBid = obj.setBid(cust, price); 

        if(validBid){
            customers.get(customers.indexOf(cust)).addMyBuyAuctionList(obj);
        }
        
    }
    
    public void soldObject(AuctionObject obj){
        obj.getBidder()
    }
    
    //Vi kan behöva att man letar efter namnet på auktionen med
}
