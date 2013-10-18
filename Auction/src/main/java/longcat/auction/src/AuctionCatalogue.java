/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import longcat.auction.utils.AbstractDAO;

/**
 *
 * @author emesven
 */
public final class AuctionCatalogue extends AbstractDAO<AuctionObject, Long> implements Serializable {
    // ArrayList<Customer> customers;
    //HashMap<Customer, List<AuctionObject>> auctionMap;
    //  HashMap<Long,AuctionObject> allAuctions = new HashMap<Long,AuctionObject>();

    public static AuctionCatalogue getDefault() {
        return new AuctionCatalogue(("auction_pu"));
    }

    public AuctionCatalogue(String puName) {
        super(AuctionObject.class, puName);
        //this.site = site;

    }

    public List<AuctionObject> getAllAuctions() {
        return getRange(0, getCount());
    }
}
