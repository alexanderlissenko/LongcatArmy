/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longcatarmy;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emesven
 */
public class AuctionCatalogue {
    public HashMap<Long,Auction> auctionList;
    public int auctionsExpired; //Date?********
    private Auction auctionInList;
    
    public AuctionCatalogue(){
        auctionList = new HashMap<Long,Auction>();
        this.auctionsExpired= 0;
    }
    public Auction getAuction(Long id){
        auctionInList = auctionList.get(id);
        return auctionInList;
    }
    public void addAuction(Long id, Auction auction){
        auctionList.put(id, auction);
    }
    public void removeAuction (Long id){
        auctionList.remove(id);
    }
    
    
    //Metoder?? inte klart??
}
