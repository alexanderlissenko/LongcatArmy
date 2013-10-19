/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.util.Date;
import java.util.List;

/**
 *
 * @author William Axhav Bratt, Emelie Svensson
 */
public class QuickTests {
    
    public static void main(String[] args)
    {
        SuperSite site = new SuperSite();
        site.initTestData();
        List<AuctionObject> a = site.auctionCatalogue.getAllAuctions();
        System.out.println(a.get(0).getName());
        
        
        System.out.println(site.customerCatalogue.find(Long.parseLong("1")).getMyBuyAuctionList().get(0).getName());
        
        /*Date today = new Date();
        System.out.println(today.getTime());            
        
        Customer testCust= new Customer("test@testing.com", "test1", "testpass", "031133742","teeeesstt","test street 1");
        Customer testCust2= new Customer("tevil@bad.com", "evil", "testpass", "031133742","teeeesstt","evil street 1");
        Customer testCust3= new Customer("test3@testing.com", "test3", "testpass", "031133742","teeeesstt","test street 3");
       
        site.getCustomerCatalogue().add(testCust);
        site.getCustomerCatalogue().add(testCust2);
        site.getCustomerCatalogue().add(testCust3);
        
        
        AuctionObject obj1 = new AuctionObject("hus","hus i pool",3131.3,today);
        AuctionObject obj2 = new AuctionObject("pool","pool till hus",1000.1,today);
        AuctionObject obj3 = new AuctionObject("evilness","evil",1.0,today);
        //testCust.addMySellAuctionList(obj1);
        
        System.out.println("Innan: " + testCust.getId() );
        testCust = site.getCustomerCatalogue().find(Long.parseLong("1"));
        System.out.println("Efter: " + testCust.getName() );
        //************************ Om ett objekt är skapat men inte tillagt kan customers ändå buda på det..... ändra?*********************************'
        
        //testing supersite
        site.createNewAuction(testCust, obj1);
        //site.getAuctionCatalogue().add(obj1);
        site.createNewAuction(testCust2, obj2);
        //site.getAuctionCatalogue().add(obj2);
        site.createNewAuction(testCust3, obj3);
        //site.getAuctionCatalogue().add(obj3);
        System.out.println("test");
        //System.out.println(site.getAllAuctionsForUser(testCust).get(0).getTitle());
        System.out.println(site.getAuctionCatalogue().getAllAuctions().get(1).getName());
        
        System.out.println(site.getCustomerCatalogue().find(testCust.getId()).getMySellAuctionList().size());
        
        System.out.println("Innan: "+site.getAuctionCatalogue().getAllAuctions().get(0).getName()+ " " +site.getAuctionCatalogue().getAllAuctions().get(0).getPrice());
        Long id = obj1.getId();
        obj1 = site.getAuctionCatalogue().find(id);
        obj1.setPrice(1.1);
        site.getAuctionCatalogue().update(obj1);
        System.out.println("Efter: "+site.getAuctionCatalogue().getAllAuctions().get(0).getName()+" "+site.getAuctionCatalogue().getAllAuctions().get(0).getPrice());
      
       // site.getCustomerCatalogue().remove(testCust2.getId());
        
        site.doBid(testCust, 0.0, obj3); //It should not change price, and it doesn't
        site.doBid(testCust, 10.0, obj3); //It should change, it does
        
        
        */
        
        /*  
        //Remove
        site.getAuctionCatalogue().removeAuction(testCust, obj1, false); //not sold
       // site.removeAuction(testCust, obj2);
        if((site.getAllAuctionsForUser(testCust).size())== 0)
            System.out.println("tomt");
        /*  
        //Do a bid
        site.doBid(testCust3, 100.0, obj2); //failed bid
        System.out.println("    Number of items in myBuyAuctionList: " +testCust3.getMyBuyAuctionList().size());
        site.doBid(testCust3, 2000.0, obj2); //bid success
        System.out.println("    Number of items in myBuyAuctionList: " +testCust3.getMyBuyAuctionList().size());
        
        
        //Admin stuff BanCustomer***********************************************************
        site.newAuction(testCust2, obj1);
        //site.newAuction(testCust2, obj2);
        site.doBid(testCust3, 2000.0, obj1); //bid success
        site.banCustomer(testCust2);
        site.newAuction(testCust2, obj3);
        
        System.out.println("    Number of items in myBuyAuctionList: " +testCust3.getMyBuyAuctionList().size());
        
        System.out.println(site.getAllAuctionsForUser(testCust2).size());
        if((site.getAllAuctionsForUser(testCust2).size())== 0)
            System.out.println("banned");
        else
            System.out.println("fel");
        
        
        
        //Test all Customer get/set (set is done in constructor)****************************
          
        System.out.println("Name: "+testCust.getName() +":");
        System.out.println("    Mail:" +testCust.getEmail());
        System.out.println("    Password: " +testCust.getPassword());
        System.out.println("    Phone: " +testCust.getPhoneNr());
        System.out.println("    seqQuest: " +testCust.getSeqQuest());
        System.out.println("    address: " +testCust.getAddress());
        System.out.println("    access: " +testCust.getAccess().toString());
        System.out.println("    Number of items in mySellAuctionList: " +testCust.getMySellAuctionList().size());
        System.out.println("    Number of items in myBuyAuctionList: " +testCust.getMyBuyAuctionList().size());
        System.out.println("    rating: " +testCust.getRating().toString());
        System.out.println("    nrOfSells: " +testCust.getNrOfSells());
        
        site.soldObject(obj2, 2000.0);
        
        
        SuperSite testFactory;
        
        //System.out.println(testFactory.getAllAuctions().size());*/
        
    }
    
    
    
   
}
