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
 *
 * @author Emelie Svensson, Alexander Lissenko
 */

@Entity
public class AuctionObject implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //uncomment when using database ****************************'
    
    private String name;
    private String info;
    private Double price;
    @Temporal(TemporalType.DATE)
    private Date expireDate; 
    private String imgLink;
    //public Customer creator;
    //private HashMap<Customer, Double> bidderMap; //för att kunna presentera listan på smidigt sätt
   // @ManyToOne
    //private List<HashMap> bidderList;
    //private List<Customer> flagList;
    //private Long id;

    public AuctionObject() {
    }
    
    //Constructor used only by admin to avoid java.util.Date
    public AuctionObject(String title, String info, Double price){
        //this.creator = creator;
        this.name = title;
        this.info = info;
        this.price = price;
        //bidderMap = new HashMap<Customer, Double>();
        //bidderList = new ArrayList<HashMap>();
    }
    
    public AuctionObject(String title, String info, Double price, Date expireDate){
        //this.creator = creator;
        this.name = title;
        this.info = info;
        this.price = price;
        this.expireDate = expireDate;
       // bidderMap = new HashMap<Customer, Double>();
       //bidderList = new ArrayList<HashMap>();
    }
    
    
    
    public AuctionObject(Long id, String title, String info, Double price, Date expireDate){
        this.id=id;
        this.name = title;
        this.info = info;
        this.price = price;
        this.expireDate = expireDate;
        //bidderMap = new HashMap<Customer, Double>();
        //bidderList = new ArrayList<HashMap>();
    }
    
    public void addFlag(Customer c){
        //implementeras senare om tid finns
    }
    /*
    public boolean setBid(Customer bidder, Double price){
        if(this.price < price) {
            //concurrency-problem! löses av ejb senare
           // bidderMap.put(bidder, price);
            bidderList.add(bidderMap);
            this.price += price;
            return true;
        }
        else {
            //nåt felmeddelande, bud kan ej vara under aktuellt bud
            System.out.println("Bud kan ej vara under " + this.price);//tillfälligt
            return false;
        }
    }*/
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
    /*public Customer getCreator(){
        return creator;
    }*/
   /* public List<HashMap> getBidder(){
       
       //return bidderList;
    }
    public HashMap<Customer, Double> getBidderMap(){
        return bidderMap;
    }
    public List<Customer> getFlagList(){
        return flagList;
    }*/
    
    
}
