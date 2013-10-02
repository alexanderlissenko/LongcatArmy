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
 * @author William Axhav Bratt
 */
public class SuperSite {
    
    
    ArrayList<Customer> customers = new ArrayList<Customer>();
    HashMap<Customer, List<AuctionObject>> temp = new HashMap<Customer, List<AuctionObject>>();
            
    
    //ArrayList<AuctionObject> auctObj = new ArrayList<AuctionObject>();
    
    SuperSite()
    {}
    
    public void newAuction(Customer cust,AuctionObject obj)
    {
        customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
        temp.get(cust).add(obj);
        
        //auctObj.add(obj);
        
    }
    
    public void addCustomer(Customer cust)
    {
        customers.add(cust);
        temp.put(cust, new ArrayList<AuctionObject>());
    }
    
    public List<AuctionObject> getAllAuctionsForUser(Customer cust)
    {
        return temp.get(cust);
    }
    
    public List<AuctionObject> getAllAuctions()
    {
        ArrayList allList = new ArrayList();
        for(List<AuctionObject> value: temp.values())
        {
            for(AuctionObject obj: value)
                allList.add(obj);
        }
        return allList;
    }
}
