/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import longcat.auction.src.Customer;

/**
 *
 * OBS! Osäker på om man ska ha @XmlElement på set-metoder
 * 
 * Vissa metoder kommer eventuellt tas bort
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
    
    //övriga metoder???
}
