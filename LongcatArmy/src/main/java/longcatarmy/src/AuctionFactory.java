/*
 * Used for testing before database is created.
 */
package longcatarmy.src;

import java.util.Date;

/**
 *
 * @author emesven
 */
public class AuctionFactory {
    
    
    //Change this when starting using the database
    
    public static SuperSite getAuction(boolean initTestData) {
        SuperSite au = SuperSite.getInstance();
        if (initTestData) {
            initTestData(au);
        }
        return au;
    }
//Behöver vi nåt slag customerregistry? Kolla i shopFactory för att se vad jag menar.
    private static void initTestData(SuperSite auction) {

        Date today = new Date();
        Customer test1 = new Customer("apa@hej.com", "apa", "password", "11111", 
                        "seQuest", "addressgatan1");
        Customer test2 = new Customer("bepa@hej.com", "bepa", "password", "22222", 
                        "seQuest", "addressgatan2");
        Customer test3 = new Customer("cepa@hej.com", "cepa", "password", "33333", 
                        "seQuest", "addressgatan3");
        Customer test4 = new Customer("depa@hej.com", "depa", "password", "44444", 
                        "seQuest", "addressgatan4");
        
        auction.addCustomer(test1);
        auction.addCustomer(test2);
        auction.addCustomer(test3);
        auction.addCustomer(test4);
        
        auction.newAuction( test1, new AuctionObject("Fisk", "info", 10.00, today));
        auction.newAuction( test1, new AuctionObject("Mås", "info", 101.00, today));
        auction.newAuction( test1, new AuctionObject("Katt", "info", 102.00, today));
        auction.newAuction( test1, new AuctionObject("Hest", "info", 103.00, today));
        auction.newAuction( test1, new AuctionObject("Dawgh", "info", 104.00, today));
        auction.newAuction( test2, new AuctionObject("ko", "info", 101.00, today));
        auction.newAuction(test3, new AuctionObject("häst", "info", 102.00, today));
        auction.newAuction(test4 , new AuctionObject("katt", "info", 103.00, today));
        
        
        /*shop.getCustomerRegistry().add(new Customer(new Address("aaa", 1, "aaa"),

        Customer c = shop.getCustomerRegistry().getByName("arne").get(0);
        c.addProductToCart(shop.getProductCatalogue().getByName("banana").get(0));
        c.addProductToCart(shop.getProductCatalogue().getByName("apple").get(0));
        c.addProductToCart(shop.getProductCatalogue().getByName("pear").get(0));

        shop.getOrderBook().add(new PurchaseOrder(c, c.getCart().getAsOrderItems()));*/

    }
}
