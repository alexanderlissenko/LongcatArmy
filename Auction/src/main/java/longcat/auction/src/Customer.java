/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Customer class
 * @author Emelie Svensson, Alexander Lissenko
 */
@Entity
public class Customer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    
    private String email;
    private String name;       
    private String password;
    private String phoneNr;
    private String seqQuest;   
    private String address;
    private Boolean access; 
    
    @OneToMany
    @JoinColumn(name= "SellList")
    private List<AuctionObject> mySellAuctionList;
    
    @OneToMany
    @JoinColumn(name= "BuyList")
    private List<AuctionObject> myBuyAuctionList;
    
    private int nrOfSells; 
    private Double rating;

    public Customer() {
    }
    
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

    public Long getId(){
        return id;
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
    
    public void setName(String name){
        this.name = name;
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
    
    public void calculateRating(double rating) {
        if(nrOfSells != 0) {
            this.rating = (rating+this.rating)/nrOfSells;
        }
        else{
            System.out.print("Illegal operation no sells yet registered");
        }
    }
    
    public void addMySellAuctionList(AuctionObject auction) {
        mySellAuctionList.add(auction);
    }
    
    public void removeMySellAuctionList(AuctionObject auction,boolean sold) {
        mySellAuctionList.remove(auction);
        if(sold){
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
    
    public int getNrOfSells(){
        return nrOfSells;
    }
}
