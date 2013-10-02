/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.src;

import java.util.Date;
import longcatarmy.src.*;

/**
 *
 * @author William Axhav Bratt
 */
public class QuickTests {
    
    public static void main(String[] args)
    {
        SuperSite site = new SuperSite();
        Date today = new Date();
        System.out.println(today.getTime());
        
        Customer testCust= new Customer("test@testing.com", "test1", "testpass", "031133742","teeeesstt","test street 1");
        
        site.addCustomer(testCust);
        
        //Customer creator, String title, String info, Double price, Date expireDate
        AuctionObject obj1 = new AuctionObject("hus","hus i pool",3131.3,today);
        //System.out.println("test");
        //testCust.addMySellAuctionList(obj1);
        
        site.newAuction(testCust, obj1);
        //System.out.println("test");
        System.out.println(site.getAllAuctionsForUser(testCust).get(0).getTitle());
        System.out.println(site.getAllAuctions().get(0).getTitle());
    }
    
    
    
   
}
