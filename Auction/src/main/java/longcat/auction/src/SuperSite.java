/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emesven
 */
public class SuperSite {

    //**********************************
    CustomerCatalogue customerCatalogue;
    AuctionCatalogue auctionCatalogue;
    //**********************************

    public SuperSite() {
        customerCatalogue = CustomerCatalogue.getDefault();
        auctionCatalogue = AuctionCatalogue.getDefault();
    }

    public CustomerCatalogue getCustomerCatalogue() {
        return customerCatalogue;
    }

    public AuctionCatalogue getAuctionCatalogue() {
        return auctionCatalogue;
    }

    public void createNewAuction(Customer cust, AuctionObject obj) {

        // Customer temp = cust; //Varför temp? **************************************************************
        Customer tmpCust=customerCatalogue.find(cust.getId());
        tmpCust.addMySellAuctionList(obj);
        auctionCatalogue.add(obj);
        customerCatalogue.update(tmpCust);
    }
    public void createNewAuction(Customer cust, AuctionObject obj, String link) {

        // Customer temp = cust; //Varför temp? **************************************************************
        Customer tmpCust=customerCatalogue.find(cust.getId());
        obj.setLink(link);
        tmpCust.addMySellAuctionList(obj);
        auctionCatalogue.add(obj);
        customerCatalogue.update(tmpCust);
    }

    public void doBid(Customer cust, Double price, AuctionObject obj) { //Ska vi använda denna? ja

        Customer tmpCust=customerCatalogue.find(cust.getId());
        AuctionObject tmpAo = auctionCatalogue.find(obj.getId());

        if (price > tmpAo.getPrice()) {
            
            tmpAo.setPrice(price); 
            auctionCatalogue.update(tmpAo);
            tmpCust.addMyBuyAuctionList(tmpAo);
           
            customerCatalogue.update(tmpCust);
        }
    }

    protected void initTestData() {

        Date today = new Date();
        today.setTime(today.getTime() + 600000);
        Customer test1 = new Customer("apa@hej.com", "apa", "password", "11111",
                "seQuest", "addressgatan1");
        Customer test2 = new Customer("bepa@hej.com", "bepa", "password", "22222",
                "seQuest", "addressgatan2");
        Customer test3 = new Customer("cepa@hej.com", "cepa", "password", "33333",
                "seQuest", "addressgatan3");
        Customer test4 = new Customer("depa@hej.com", "depa", "password", "44444",
                "seQuest", "addressgatan4");

        AuctionObject testobj1 = new AuctionObject("Fisk", "Trut", 10.00, today);
        AuctionObject testobj2 = new AuctionObject("Mås", "Stronk", 101.00, today);
        AuctionObject testobj3 = new AuctionObject("Katt", "Våt", 102.00, today);
        AuctionObject testobj4 = new AuctionObject("Gin-o-tonic häst", "Bra tänder", 103.00, today);
        AuctionObject testobj5 = new AuctionObject("Dawgh", "Rabies", 104.00, today);
        AuctionObject testobj6 = new AuctionObject("Fin-Ko", "Säljare: Einstein", 101.00, today);
        AuctionObject testobj7 = new AuctionObject("Photogenic häst", "Look at how beautiful he is. LOOK AT HIM.", 102.00, today);
        AuctionObject testobj8 = new AuctionObject("Army-cat", "Beware, use with caution", 103.00, today);

        customerCatalogue.add(test1);
        customerCatalogue.add(test2);
        customerCatalogue.add(test3);
        customerCatalogue.add(test4);

        createNewAuction(test1, testobj1,"http://cdn1.cdnme.se/cdn/9-1/394917/images/2010/fulfisk_74607507.jpg");
        createNewAuction(test1, testobj2,"http://www.iywib.com/birds_with_arms5.jpg");
        createNewAuction(test1, testobj3,"http://www.skunkwire.com/wp-content/uploads/2013/09/shocked-cat.jpg");
        createNewAuction(test1, testobj4,"http://www.funnypica.com/wp-content/uploads/2012/04/silly-funny-horse-pictures.jpg");
        createNewAuction(test1, testobj5,"http://4.bp.blogspot.com/_qUFDMUpk9jE/TAQuoydqvzI/AAAAAAAAi2A/xISdNbBCMRc/s1600/dog-aggressive.jpg");
        createNewAuction(test2, testobj6,"http://media-cdn.tripadvisor.com/media/photo-s/03/0e/8a/f9/crazy-cow-steakhouse.jpg");
        createNewAuction(test3, testobj7,"http://i.imgur.com/ikwUmUV.jpg");
        createNewAuction(test4, testobj8,"http://inventorspot.com/files/images/army-cat.img_assist_custom.jpg");

        doBid(test1, 10000.0, testobj6);
        /*
         auctionCatalogue.add(testobj1);
         auctionCatalogue.add(testobj2);
         auctionCatalogue.add(testobj3);
         auctionCatalogue.add(testobj4);
         auctionCatalogue.add(testobj5);
         auctionCatalogue.add(testobj6);
         auctionCatalogue.add(testobj7);
        
         auctionCatalogue.add(testobj8);
         */
        //auctionCatalogue.doBid(test1, 1000.1, testobj6);


        /*shop.getCustomerRegistry().add(new Customer(new Address("aaa", 1, "aaa"),

         Customer c = shop.getCustomerRegistry().getByName("arne").get(0);
         c.addProductToCart(shop.getProductCatalogue().getByName("banana").get(0));
         c.addProductToCart(shop.getProductCatalogue().getByName("apple").get(0));
         c.addProductToCart(shop.getProductCatalogue().getByName("pear").get(0));

         shop.getOrderBook().add(new PurchaseOrder(c, c.getCart().getAsOrderItems()));*/

    }
}
