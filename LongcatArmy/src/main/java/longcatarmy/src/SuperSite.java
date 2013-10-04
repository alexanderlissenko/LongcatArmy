/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



/**
 *
 * @author William Axhav Bratt, Emelie Svensson
 */
public class SuperSite {

    
    ArrayList<Customer> customers;
    HashMap<Customer, List<AuctionObject>> auctionMap;
    Boolean t
    
    
    //ArrayList<AuctionObject> auctObj = new ArrayList<AuctionObject>();
    
    public SuperSite()
    {
        customers = new ArrayList<Customer>();
        auctionMap = new HashMap<Customer, List<AuctionObject>>();
    }
    
    public void newAuction(Customer cust,AuctionObject obj)
    {   
        t =cust.getAccess();
        if(t== true){    
            customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
            auctionMap.get(cust).add(obj);   
        }
    }
    
    public void removeAuction(Customer cust,AuctionObject obj){
        auctionMap.get(cust).remove(obj);
    }
    
    public void updateAuction(Customer cust, AuctionObject obj){
        removeAuction(cust,obj);
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
    
    //Vi kan behöva att man letar efter namnet på auktionen med
}
