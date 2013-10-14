/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

/**
 *
 * OBS! Osäker på när man ska ha @XmlElement, kolla upp!
 * 
 * Vissa metoder kommer eventuellt tas bort, beroende på vad vi implementerar
 * 
 * @author Alexander Lissenko
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CustomerProxy {
    
    private Customer customer;
    
    protected CustomerProxy(){
        
    }
    
    public CustomerProxy(Customer customer){
        this.customer = customer;
    }
    
    @XmlElement
    public String getEmail(){
        return customer.getEmail();
    }
    
    @XmlElement
    public void setEmail(String email){
        customer.setEmail(email);
    }
    
    @XmlElement
    public String getPassword() {
        return customer.getPassword();
    } 
    
    @XmlElement
    public void setPassword(String password){
        customer.setPassword(password);
    }  
    
    @XmlElement
    public String getName() {
        return customer.getName();
    }
    
    @XmlElement
    public String getPhoneNr() {
        return customer.getPhoneNr();
    }
    
    @XmlElement
    public void setPhoneNr(String phoneNr) {
        customer.setPhoneNr(phoneNr);
    }
    
    @XmlElement
    public String getSeqQuest() {
        return customer.getSeqQuest();
    }
    
    @XmlElement
    public void setSeqQuest(String seqQuest) {
        customer.setSeqQuest(seqQuest);
    }
    
    @XmlElement
    public String getAddress() {
        return customer.getAddress();
    }
    
    @XmlElement
    public void setAddress(String address) {
        customer.setAddress(address);
    }
    
    @XmlElement
    public Boolean getAccess() {
        return customer.getAccess();
    }
    
    @XmlElement
    public void setAccess(Boolean access) {
        customer.setAccess(access);
    }
    
    @XmlElement
    public Double getRating() {
        return customer.getRating();
    }
    
    @XmlElement
    public void setRating(Double rate) {
        customer.setRating(rate);
    }
    
    @XmlElement
    public List<AuctionObject> getCustSellAuctionList() {
        return customer.getMySellAuctionList();
    }
    
    @XmlElement
    public void removeCustSellAuction(AuctionObject auction){
        customer.getMySellAuctionList().remove(auction);
    }
    
    @XmlElement
    public void removeCustBuyAuction(AuctionObject auction) {
        customer.getMyBuyAuctionList().remove(auction);
    }
    
    @XmlElement
    public List<AuctionObject> getMyBuyAuctionList() {
        return customer.getMyBuyAuctionList();
    }
    
    @XmlElement
    public void emptyCustLists(){
        customer.getMySellAuctionList().clear();
        customer.getMyBuyAuctionList().clear();
    }
    //övriga metoder känns inte relevant för admin att accessa
}
