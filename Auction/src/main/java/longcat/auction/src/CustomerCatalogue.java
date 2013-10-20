/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.io.Serializable;
import java.util.List;
import longcat.auction.utils.AbstractDAO;

/**
 * Container class for customers
 * 
 * @author Emelie Svensson
 */
public final class CustomerCatalogue extends AbstractDAO<Customer, Long> implements Serializable {

    static CustomerCatalogue getDefault() {
        return new CustomerCatalogue(("auction_pu"));
    }

    public CustomerCatalogue(String puName) {
        super(Customer.class, puName);
    }

    public List<AuctionObject> getAllAuctionsForUser(Customer cust) {
        return find(cust.getId()).getMySellAuctionList();
    }
}
