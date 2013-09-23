/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.longcatarmy;

import java.util.List;
import java.util.Date;

/**
 *
 * @author emesven
 */
public class Auction {
    public String title;
    public String info;
    public Double price;
    public Date expireDate; 
    public Customer creator;
    public List<Customer> bidder;
    public List<Customer> flagList;
    public Long id;
    
    public Auction(Customer creator, String title, String info, Double price, Date expireDate){
        
    }
    
    public void addFlag(Customer c){
        
    }
    public void setBid(Double price){
        
    }
    public String getTitle(){
        return title;
    }
    public String getInfo(){
        return info;
    }
    public Double getPrice(){
        return price;
    }
    public Date getExpire() {
        return expireDate;
    }
    public Customer getCreator(){
        return creator;
    }
    public List<Customer> getBidder(){
        return bidder;
    }
    public List<Customer> getFlagList(){
        return flagList;
    }
    public Long getId(){
        return id;
    }
}
