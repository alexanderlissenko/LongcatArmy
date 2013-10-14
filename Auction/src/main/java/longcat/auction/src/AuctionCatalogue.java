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
public final class AuctionCatalogue extends AbstractDAO<AuctionObject, Long> implements Serializable  {
    SuperSite site;
   // ArrayList<Customer> customers;
    //HashMap<Customer, List<AuctionObject>> auctionMap;
    HashMap<Long,AuctionObject> allAuctions = new HashMap<Long,AuctionObject>();
    
    public AuctionCatalogue(String puName, SuperSite site) {
        super(AuctionObject.class,puName);
        //this.site = site;
       
    }
    
   /* public void initiate(){
        customers = site.getCustomerCatalogue().getCustomers();
        auctionMap = site.getCustomerCatalogue().getAuctionMap();
    }*/
    
  /* public void newAuction(Customer cust,AuctionObject obj)
    {   
        initiate();
        if(cust.getAccess()){ 
            customers.get(customers.indexOf(cust)).addMySellAuctionList(obj);
            auctionMap.get(cust).add(obj);
      
        }
    }*/
    
   /* public void removeAuction(Customer cust,AuctionObject obj,Boolean sold){
        initiate();
        customers.get(customers.indexOf(cust)).removeMySellAuctionList(obj, sold); 
        auctionMap.get(cust).remove(obj);
    }*/
    
    /*public void updateAuction(Customer cust, AuctionObject obj){
        initiate();
        removeAuction(cust,obj,false); //fasle because it is not sold here
        newAuction(cust,obj);
    }*/
        
    /*public List<AuctionObject> getAllAuctions()
    {
        initiate();
        ArrayList allList = new ArrayList();
        for(List<AuctionObject> value: auctionMap.values())
        {
            for(AuctionObject obj: value)
                allList.add(obj);
        }
        return allList;
    }*/
    
     /*public void doBid(Customer cust, Double price, AuctionObject obj){ //Ska vi använda denna?
        initiate();
        Boolean validBid = obj.setBid(cust, price); 

        if(validBid){
            customers.get(customers.indexOf(cust)).addMyBuyAuctionList(obj);
        }
        
    }*/
     /**************************************************************
     public void soldObject(AuctionObject obj, Double price){
        //initiate();
        //Remove from buyer buyList
        Customer seller = null;
        for ( HashMap<Customer, Double> o : obj.getBidder()){     
            for ( Map.Entry<Customer, Double> p:o.entrySet()){
                if (price.equals(p.getValue())){  
                    p.getKey().removeMyBuyAuctionList(obj);
                    System.out.println("object is sold"); 
                }
            }
        }
        
        //Remove from sellers sellList
        for (Map.Entry<Customer, List<AuctionObject>> s: auctionMap.entrySet()){
            for (AuctionObject ao : s.getValue()){
                if (obj.equals(ao)){
                    seller = s.getKey();                    
                    System.out.println("Right object");
                }
            }                       
        }
        removeAuction(seller,obj ,true);
    }
     
     public HashMap getAllAuctionsMappedById() {
        allAuctions = new HashMap<Long,AuctionObject>();
        for(Map.Entry<Customer, List<AuctionObject>> s: auctionMap.entrySet()){
            for(AuctionObject ao : s.getValue()){
                allAuctions.put(ao.getId(), ao);
            }
        }
        return allAuctions;
    }
    
    public AuctionObject getAuction(Long id) {
        return allAuctions.get(id);
    }/*************************************************************************
     

    
    
    /*public HashMap<Long,AuctionObject> auctionList;
    public int auctionsExpired; //Date?********
    private AuctionObject auctionInList;
    
    public AuctionCatalogue(){
        auctionList = new HashMap<Long,AuctionObject>();
        this.auctionsExpired= 0;
    }
    public AuctionObject getAuction(Long id){
        auctionInList = auctionList.get(id);
        return auctionInList;
    }
    public void addAuction(Long id, AuctionObject auction){
        auctionList.put(id, auction);
    }
    public void removeAuction (Long id){
        auctionList.remove(id);
    }
    
    
    //Metoder?? inte klart??*/  //****************************************VAD ÄR DETTA
}
