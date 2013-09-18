/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longcatarmy;

import java.util.List;

/**
 *
 * @author emesven
 */
public class Customer implements User {
    private String email;
    private String name;       
    private String password;
    private String phoneNr;
    private String seqQuest;   
    private String address;
    private Boolean access; //Ligga i User
    private List<Auction> mySellAuctionList;
    private List<Auction> myBuyAuctionList;
    private int noOfAuctions;
    private Double rating;
    
    public Customer(String email, String name, String pass, String phone, 
                        String seQuest, String address){
        
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        
    }
    public String getPassword() {
        return password;
    } public void setPassword(String password){
    
    }  
    public String getName() {
        return name;
    }
    
    public String getPhoneNr() {
        return phoneNr;
    }
    public void setPhoneNr(String phoneNr) {
        
    }
    public String getSeqQuest() {
        return seqQuest;
    }
    public void setQuest(String seqQuest) {
    
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
    
    }
    public Boolean getAccess() {
        return access;
    }
    public void setAccess(Boolean access) {
    
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rate) {
    
    }
    public void addMySellAuctiionList(Auction auction) {
    
    }
    public void removeMySellAuctionList(Auction auction) {
    
    }
    public List<Auction> getMySellAuctionList() {
        return mySellAuctionList;
    }
    public void addMyBuyAuctionList(Auction auction) {
    
    }
    public void removeMyBuyAuctionList(Auction auction) {
    
    }
    public List<Auction> getMyBuyAuctionList() {
        return myBuyAuctionList;
    }
    
}
