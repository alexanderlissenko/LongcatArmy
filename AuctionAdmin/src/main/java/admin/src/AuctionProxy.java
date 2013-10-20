/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.src;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;

/**
 *
 * Proxy class used for representing Auction objects as Xml
 * @author Alexander Lissenko
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class AuctionProxy {

    private AuctionObject obj;

    protected AuctionProxy() {
    }

    public AuctionProxy(AuctionObject obj) {
        this.obj = obj;
    }

    @XmlElement
    public String getName() {
        return obj.getName();
    }

    public void setName(String name) {
        obj.setName(name);
    }

    @XmlElement
    public String getInfo() {
        return obj.getInfo();
    }

    public void setInfo(String info) {
        obj.setInfo(info);
    }

    @XmlElement
    public Double getPrice() {
        return obj.getPrice();
    }

    public void setPrice(Double price) {
        obj.setPrice(price);
    }

    @XmlElement
    public Date getExpire() {
        return obj.getExpire();
    }

    @XmlElement
    public Long getId() {
        return obj.getId();
    }
}
