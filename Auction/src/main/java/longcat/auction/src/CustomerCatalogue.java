/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import longcat.auction.utils.AbstractDAO;

/**
 *
 * @author emesven
 */
public final class CustomerCatalogue extends AbstractDAO<Customer, Long> implements Serializable  {
   // ArrayList<Customer> customers;
    SuperSite site;
    //HashMap<Customer, List<AuctionObject>> auctionMap;
     
    
    public CustomerCatalogue(String puName, SuperSite site){
        super(Customer.class,puName);
        this.site = site;
        //customers = new ArrayList<Customer>();
        //auctionMap = new HashMap<Customer, List<AuctionObject>>();
    }
    
    
    /*public void addCustomer(Customer cust)
    {
        customers.add(cust);
        auctionMap.put(cust, new ArrayList<AuctionObject>());
    }*/
    
    /*public List<AuctionObject> getAllAuctionsForUser(Customer cust)
    {
        return auctionMap.get(cust);
    }*/
    
    /*public void banCustomer(Customer cust){
        cust.setAccess(false);
        cust.emptyMyLists(); 
        for (AuctionObject al:auctionMap.get(cust)){
            HashMap<Customer, Double> temp =al.getBidderMap();
            
            for(Map.Entry<Customer,Double> p : temp.entrySet()){
                p.getKey().removeMyBuyAuctionList(al);
            }                   
        }
        auctionMap.get(cust).clear();
        
    }*/
   
    /*
    public void updateCustomer (String name,String email, String pass, String phone, 
                        String seQuest, String address){
        Customer updated = getCustomerByName(name);
        updated.setEmail(email);
        updated.setPassword(pass);
        updated.setPhoneNr(phone);
        updated.setSeqQuest(seQuest);
        updated.setAddress(address);
    }
    public void updateCustomer (String name,Customer cust){
        Customer updated = getCustomerByName(name);
        updated.setEmail(cust.getEmail());
        updated.setPassword(cust.getPassword());
        updated.setPhoneNr(cust.getPhoneNr());
        updated.setSeqQuest(cust.getSeqQuest());
        updated.setAddress(cust.getAddress());
    }*/
}
