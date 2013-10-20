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
 * Proxy class used for representing Customer objects as Xml
 * @author Alexander Lissenko
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CustomerProxy {

    private Customer customer;

    protected CustomerProxy() {
    }

    public CustomerProxy(Customer customer) {
        this.customer = customer;
    }
    
    @XmlElement
    public Long getId() {
        return customer.getId();
    }

    @XmlElement
    public String getEmail() {
        return customer.getEmail();
    }

    public void setEmail(String email) {
        customer.setEmail(email);
    }

    @XmlElement
    public String getPassword() {
        return customer.getPassword();
    }

    public void setPassword(String password) {
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

    public void setPhoneNr(String phoneNr) {
        customer.setPhoneNr(phoneNr);
    }

    @XmlElement
    public String getSeqQuest() {
        return customer.getSeqQuest();
    }

    public void setSeqQuest(String seqQuest) {
        customer.setSeqQuest(seqQuest);
    }

    @XmlElement
    public String getAddress() {
        return customer.getAddress();
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }
}
