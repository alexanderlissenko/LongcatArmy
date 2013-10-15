/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Singleton;
import javax.persistence.Persistence;
import longcat.auction.utils.AbstractDAO;



/**
 *
 * @author William Axhav Bratt, Emelie Svensson
 */

public class SuperSiteOld extends AbstractDAO<Customer,Long> implements Serializable  {

    //DAtabase
    //String puName;

    
    ArrayList<Customer> customers;
    HashMap<Customer, List<AuctionObject>> auctionMap;
    Boolean validBid;
    Customer seller;
    Customer updated;
    HashMap<Long,AuctionObject> allAuctions = new HashMap<Long,AuctionObject>();
    
    //ArrayList<AuctionObject> auctObj = new ArrayList<AuctionObject>();
 
    public SuperSiteOld()
    {
        super(Customer.class,"auction_pu");
        customers = new ArrayList<Customer>();
        auctionMap = new HashMap<Customer, List<AuctionObject>>();
        //emf = Persistence.createEntityManagerFactory(puName);
    }
    
    //Tagit
    public void newAuction(Customer cust,AuctionObject obj)
    {   
        if(cust.getAccess()){    
            customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
            auctionMap.get(cust).add(obj);
      
        }
    }
    //Tagit
    public void removeAuction(Customer cust,AuctionObject obj,Boolean sold){
        customers.get(customers.indexOf(cust)).removeMySellAuctionList(obj, sold); 
        auctionMap.get(cust).remove(obj);
    }
    //TAgit
    public void updateAuction(Customer cust, AuctionObject obj){
        removeAuction(cust,obj,false); //fasle because it is not sold here
        newAuction(cust,obj);
    }
    //tagit
    public void addCustomer(Customer cust)
    {
        
        customers.add(cust);
        auctionMap.put(cust, new ArrayList<AuctionObject>());
    }
    //tagit
    public List<AuctionObject> getAllAuctionsForUser(Customer cust)
    {
        return auctionMap.get(cust);
    }
    //tagit
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
    //tagit
    /*public void banCustomer(Customer cust){
        cust.setAccess(false);
        cust.emptyMyLists(); 
        for (AuctionObject al:auctionMap.get(cust)){
            HashMap<Customer, Double> temp =al.getBidderMap();
            
            for(Entry<Customer,Double> p : temp.entrySet()){
                p.getKey().removeMyBuyAuctionList(al);
            }                   
        }
        auctionMap.get(cust).clear();
        
    }*/
    //tagit
    /*public void doBid(Customer cust, Double price, AuctionObject obj){ //Ska vi använda denna?
        validBid = obj.setBid(cust, price); 

        if(validBid){
            customers.get(customers.indexOf(cust)).addMyBuyAuctionList(obj);
        }
        
    }*/
    //tagit
   /* public void soldObject(AuctionObject obj, Double price){
        
        //Remove from buyer buyList
        for ( HashMap<Customer, Double> o : obj.getBidder()){     
            for ( Entry<Customer, Double> p:o.entrySet()){
                if (price.equals(p.getValue())){  
                    p.getKey().removeMyBuyAuctionList(obj);
                    System.out.println("object is sold"); 
                }
            }
        }*/
        /*
        //Remove from sellers sellList
        for (Entry<Customer, List<AuctionObject>> s: auctionMap.entrySet()){
            for (AuctionObject ao : s.getValue()){
                if (obj.equals(ao)){
                    seller = s.getKey();                    
                    System.out.println("Right object");
                }
            }                       
        }
        removeAuction(seller,obj ,true);;
    }
    //tagit
    public Customer getCustomerByName(String name)
    {
        for(int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getName().equals(name))
                return customers.get(i);
        }
        return null;
    }
    
    //påbörjad, för att få ut objects utan customers
    public HashMap getAllAuctionsMappedById() {
        allAuctions = new HashMap<Long,AuctionObject>();
        for(Entry<Customer, List<AuctionObject>> s: auctionMap.entrySet()){
            for(AuctionObject ao : s.getValue()){
                allAuctions.put(ao.getId(), ao);
            }
        }
        return allAuctions;
    }
    
    public AuctionObject getAuction(Long id) {
        return allAuctions.get(id);
    }
    //tagit
    public void updateCustomer (String name,String email, String pass, String phone, 
                        String seQuest, String address){
        updated = getCustomerByName(name);
        updated.setEmail(email);
        updated.setPassword(pass);
        updated.setPhoneNr(phone);
        updated.setSeqQuest(seQuest);
        updated.setAddress(address);
    }
    //tagit
    public void updateCustomer (String name,Customer cust){
        updated = getCustomerByName(name);
        updated.setEmail(cust.getEmail());
        updated.setPassword(cust.getPassword());
        updated.setPhoneNr(cust.getPhoneNr());
        updated.setSeqQuest(cust.getSeqQuest());
        updated.setAddress(cust.getAddress());
    }
 
    protected void initTestData() {

        Date today = new Date();
        Customer test1 = new Customer("apa@hej.com", "apa", "password", "11111", 
                        "seQuest", "addressgatan1");
        Customer test2 = new Customer("bepa@hej.com", "bepa", "password", "22222", 
                        "seQuest", "addressgatan2");
        Customer test3 = new Customer("cepa@hej.com", "cepa", "password", "33333", 
                        "seQuest", "addressgatan3");
        Customer test4 = new Customer("depa@hej.com", "depa", "password", "44444", 
                        "seQuest", "addressgatan4");
        
        AuctionObject testobj1 = new AuctionObject("Fisk", "info", 10.00, today);
        AuctionObject testobj2 = new AuctionObject("Mås", "info", 101.00, today);
        AuctionObject testobj3 = new AuctionObject("Katt", "info", 102.00, today);
        AuctionObject testobj4 = new AuctionObject("Hest", "info", 103.00, today);
        AuctionObject testobj5 = new AuctionObject("Dawgh", "info", 104.00, today);
        AuctionObject testobj6 = new AuctionObject("ko", "info", 101.00, today);
        AuctionObject testobj7 = new AuctionObject("häst", "info", 102.00, today);
        AuctionObject testobj8 = new AuctionObject("katt", "info", 103.00, today);
                
        
        addCustomer(test1);
        addCustomer(test2);
        addCustomer(test3);
        addCustomer(test4);
        
        
        
        newAuction( test1, testobj1);
        newAuction( test1, testobj2);
        newAuction( test1, testobj3);
        newAuction( test1, testobj4);
        newAuction( test1, testobj5);
        newAuction( test2, testobj6);
        newAuction(test3, testobj7);
        
        newAuction(test4 , testobj8);
        
        doBid(test1, 1000.1, testobj6);
        
        
        /*shop.getCustomerRegistry().add(new Customer(new Address("aaa", 1, "aaa"),

        Customer c = shop.getCustomerRegistry().getByName("arne").get(0);
        c.addProductToCart(shop.getProductCatalogue().getByName("banana").get(0));
        c.addProductToCart(shop.getProductCatalogue().getByName("apple").get(0));
        c.addProductToCart(shop.getProductCatalogue().getByName("pear").get(0));

        shop.getOrderBook().add(new PurchaseOrder(c, c.getCart().getAsOrderItems()));*/

    //}
    
    //Vi kan behöva att man letar efter namnet på auktionen med
}
