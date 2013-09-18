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
    public Date expireDate; //datum hur?
    public Customer creator;
    public List<Customer> bidder;
    public List<Customer> flagList;
    
    public Auction(Customer creator, String title, String info, Double price, Date expireDate){
        
    }
    
    public void addFlag(Customer c){
        
    }
    public void setBid(Double price){
        
    }
}
