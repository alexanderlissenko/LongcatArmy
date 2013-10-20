/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Auction object class
 * @author Emelie Svensson, Alexander Lissenko
 */

@Entity
public class AuctionObject implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    private String name;
    private String info;
    private Double price;
    
    @Temporal(TemporalType.DATE)
    private Date expireDate; 
    
    private String imgLink;
    
    public AuctionObject() {
    }
    
    public AuctionObject(String title, String info, Double price, Date expireDate){
        this.name = title;
        this.info = info;
        this.price = price;
        this.expireDate = expireDate;
    }
    
    public AuctionObject(Long id, String title, String info, Double price, Date expireDate){
        this.id=id;
        this.name = title;
        this.info = info;
        this.price = price;
        this.expireDate = expireDate;
    }
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLink(){
        return imgLink;
    }
     
    public void setLink(String link){
        this.imgLink = link;
    }
    
    public String getInfo(){
        return info;
    }
    
    public void setInfo(String info) {
        this.info = info;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public void setPrice(Double price){
        this.price = price;
    }
    
    public Date getExpire() {
        return expireDate;
    }
    
    public void setExpire(Date expireDate) {
        this.expireDate = expireDate;
    }
}
