/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import longcat.auction.src.AuctionCatalogue;
import longcat.auction.src.CustomerCatalogue;
import longcat.auction.src.SuperSite;

/**
 * Connection with the model
 * @author Alexander Lissenko
 */
public enum Site {
    INSTANCE;
    
    private final SuperSite site;
    
    private Site(){
        site = new SuperSite();
    }
    
    public AuctionCatalogue getAuctionCatalogue() {
        return site.getAuctionCatalogue();
    }
    
    public CustomerCatalogue getCustomerCatalogue() {
        return site.getCustomerCatalogue();
    }
}
