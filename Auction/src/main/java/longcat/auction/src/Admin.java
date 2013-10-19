/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcat.auction.src;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author emesven
 */

@Entity
public class Admin implements User{
    
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
    
    
    public Admin()
    {
        
    }
    
    
    public Admin(String email, String name, String pass, String phone, 
                        String seQuest, String address){
        this.email = email;
        this.name = name;
        this.password = pass;
        this.phoneNr = phone;
        this.seqQuest = seQuest;
        this.address = address;
        access = true;
        
        
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
    public void setQuest(String seqQuest) {
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
    public void changeAccess(Customer c, Boolean b){
        c.setAccess(b);
    }
}
