/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexander Lissenko
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AuctionObjectProxy {
    
    private AuctionObject obj;
    
    protected AuctionObjectProxy() {
        
    }
    
    public AuctionObjectProxy(AuctionObject obj) {
        this.obj = obj;
    }
    
    @XmlElement
    public String getTitle(){
        return obj.getTitle();
    }
    
    @XmlElement
    public String getInfo(){
        return obj.getInfo();
    }
    
    @XmlElement
    public Double getPrice(){
        return obj.getPrice();
    }
    
    @XmlElement
    public Date getExpire() {
        return obj.getExpire();
    }
    
    @XmlElement
    public List<HashMap> getBidder(){
        return obj.getBidder();
    }
    
    @XmlElement
    public List<Customer> getFlagList(){
        return obj.getFlagList();
    }
    
    @XmlElement
    public Long getId(){
        return obj.getId();
    }
}
