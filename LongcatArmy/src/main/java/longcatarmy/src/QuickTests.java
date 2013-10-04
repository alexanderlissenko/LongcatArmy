/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.Date;
import longcatarmy.src.*;

/**
 *
 * @author William Axhav Bratt, Emelie Svensson
 */
public class QuickTests {
    
    public static void main(String[] args)
    {
        SuperSite site = new SuperSite();
        Date today = new Date();
        System.out.println(today.getTime());
        
        Admin a;
            
        
        Customer testCust= new Customer("test@testing.com", "test1", "testpass", "031133742","teeeesstt","test street 1");
        Customer testCust2= new Customer("tevil@bad.com", "evil", "testpass", "031133742","teeeesstt","evil street 1");
        
        site.addCustomer(testCust);
        site.addCustomer(testCust2);
        
        //Customer creator, String title, String info, Double price, Date expireDate
        AuctionObject obj1 = new AuctionObject("hus","hus i pool",3131.3,today);
        AuctionObject obj2 = new AuctionObject("pool","pool till hus",1000.1,today);
        AuctionObject obj3 = new AuctionObject("evilness","evil",1.0,today);
        //System.out.println("test");
        //testCust.addMySellAuctionList(obj1);
        
        
        //testing supersite********************************************************
        site.newAuction(testCust, obj1);
        site.newAuction(testCust, obj2);
        //System.out.println("test");
        System.out.println(site.getAllAuctionsForUser(testCust).get(0).getTitle());
        System.out.println(site.getAllAuctions().get(1).getTitle());
        
        
        System.out.println("Innan: "+site.getAllAuctions().get(0).getPrice());
        obj1.setPrice(1.1);
        site.updateAuction(testCust, obj1);
        System.out.println("Efter: "+site.getAllAuctions().get(1).getPrice());
        
        //Remove
        site.removeAuction(testCust, obj1);
       // site.removeAuction(testCust, obj2);
        if((site.getAllAuctionsForUser(testCust).size())== 0)
            System.out.println("tomt");
        
        //Admin stuff****************************************************************
        testCust2.setAccess(false);
        site.newAuction(testCust2, obj3);
        System.out.println(site.getAllAuctionsForUser(testCust2).size());
        if((site.getAllAuctionsForUser(testCust2).size())== 0)
            System.out.println("banned");
        else
            System.out.println("fel");
        
    }
    
    
    
   
}
