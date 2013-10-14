/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import longcat.auction.utils.AbstractDAO;

/**
 *
 * @author emesven
 */
public class CustomerCatalogue extends AbstractDAO<Customer, Long> {
    ArrayList<Customer> customers;
    SuperSite site;
    Customer updated;
    HashMap<Customer, List<AuctionObject>> auctionMap;
    public CustomerCatalogue(String puName, SuperSite site){
        super(Customer.class,puName);
        this.site = site;
        customers = new ArrayList<Customer>();
        auctionMap = new HashMap<Customer, List<AuctionObject>>();
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    public HashMap<Customer, List<AuctionObject>> getAuctionMap(){
        return auctionMap;
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
    
    public void banCustomer(Customer cust){
        cust.setAccess(false);
        cust.emptyMyLists(); 
        for (AuctionObject al:auctionMap.get(cust)){
            HashMap<Customer, Double> temp =al.getBidderMap();
            
            for(Map.Entry<Customer,Double> p : temp.entrySet()){
                p.getKey().removeMyBuyAuctionList(al);
            }                   
        }
        auctionMap.get(cust).clear();
        
    }
    //behövs denna det finns en liknadnde i DAO******************************''
    public Customer getCustomerByName(String name)
    {
        for(int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }
    
    public void updateCustomer (String name,String email, String pass, String phone, 
                        String seQuest, String address){
        updated = getCustomerByName(name);
        updated.setEmail(email);
        updated.setPassword(pass);
        updated.setPhoneNr(phone);
        updated.setSeqQuest(seQuest);
        updated.setAddress(address);
    }
    public void updateCustomer (String name,Customer cust){
        updated = getCustomerByName(name);
        updated.setEmail(cust.getEmail());
        updated.setPassword(cust.getPassword());
        updated.setPhoneNr(cust.getPhoneNr());
        updated.setSeqQuest(cust.getSeqQuest());
        updated.setAddress(cust.getAddress());
    }
}
