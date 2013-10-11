/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Emelie Svensson, Alexander Lissenko
 */
@Entity
public class Customer implements User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //uncomment when using database ******************************
    
    private String email;
    private String name;       
    private String password;
    private String phoneNr;
    private String seqQuest;   
    private String address;
    private Boolean access; //Ligga i User
    private List<AuctionObject> mySellAuctionList;
    private List<AuctionObject> myBuyAuctionList;
    private int nrOfSells; //FInns denna som set/get?
    private Double rating;
    
    public Customer(String email, String name, String pass, String phone, 
                        String seQuest, String address){
        this.email = email;
        this.name = name;
        this.password = pass;
        this.phoneNr = phone;
        this.seqQuest = seQuest;
        this.address = address;
        rating = 0.0;
        mySellAuctionList = new ArrayList<AuctionObject>();
        myBuyAuctionList = new ArrayList<AuctionObject>();
        access = true;
        nrOfSells = 0;
        
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword() {
        return password;
    } 
    public void setPassword(String password){
        this.password = password;
    }  
    public String getName() {
        return name;
    }
    public String getPhoneNr() {
        return phoneNr;
    }
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }
    public String getSeqQuest() {
        return seqQuest;
    }
    public void setSeqQuest(String seqQuest) {
        this.seqQuest = seqQuest;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Boolean getAccess() {
        return access;
    }
    public void setAccess(Boolean access) {
        this.access = access;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rate) {
        this.rating = rate;
    }
    public void calculateRating(double rating)// Behver att ses över igen efter test
    {
        if(nrOfSells != 0)
        {
        this.rating = (rating+this.rating)/nrOfSells;
        }
        else
        {
            System.out.print("Illegal operation no sells yet registerd");//tillfälligt error medelande
        }
    }
    public void addMySellAuctionList(AuctionObject auction) {
        mySellAuctionList.add(auction);
    }
    public void removeMySellAuctionList(AuctionObject auction,boolean sold) {
        mySellAuctionList.remove(auction);
        if(sold)
        {
            nrOfSells++;
        }
    }
    public List<AuctionObject> getMySellAuctionList() {
        return mySellAuctionList;
    }
    public void addMyBuyAuctionList(AuctionObject auction) {
        myBuyAuctionList.add(auction);
    }
    public void removeMyBuyAuctionList(AuctionObject auction) {
        myBuyAuctionList.remove(auction);
    }
    public List<AuctionObject> getMyBuyAuctionList() {
        return myBuyAuctionList;
    }
    
    public void emptyMyLists(){
        mySellAuctionList.clear();
        myBuyAuctionList.clear();
    }
    
    //nrOfSales??????? ***********************************Detta var inte med.. något vi har bestämt?
    public int getNrOfSells(){
        return nrOfSells;
    }
}
