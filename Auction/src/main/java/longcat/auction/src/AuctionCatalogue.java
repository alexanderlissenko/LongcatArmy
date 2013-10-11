/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author emesven
 */
public class AuctionCatalogue {
    public HashMap<Long,AuctionObject> auctionList;
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
    
    
    //Metoder?? inte klart??
}
