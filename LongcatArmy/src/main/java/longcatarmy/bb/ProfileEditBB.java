/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;
import longcatarmy.src.Customer;
import longcatarmy.src.SuperSite;

/**
 *
 * @author William Axhav Bratt
 */
@ConversationScoped
@Named("profileEdit")
public class ProfileEditBB implements Serializable{
    
    Customer cust;
    String eMail;
    String password;
    String phone;
    String secQuest;
    String address;
    AuctionBB test = AuctionBB.INSTANCE;
    SuperSite site = test.createSuperSite();
    
    public ProfileEditBB()
    {
        cust = site.getCustomerByName("apa");
    }
    
    @PostConstruct
    public void post()
    { 
    }
    
    
    public String actOnSelected()
    {
        site.updateCustomer("apa",cust);
        return goToView();
    }  
    
    public String goToView()
    {
        return "profile";
    }
    public void setName(String name)
    {
        //incase of buggs does not do anything
    }
    
    public void setEmail(String eMail)
    {
        cust.setEmail(eMail);
    }
    
    public void setPassword(String password)
    {
        cust.setPassword(password);
    }
    
    public void setPhone(String phone)
    {
        cust.setPhoneNr(phone);
    }
    
    public void setSeqQuest(String secQuest)
    {
        cust.setSeqQuest(secQuest);
    }
    
    public void setAddress(String address)
    {
        cust.setAddress(address);
    }
    
    public String getName()
    {
        return cust.getName();
    }
    
    public String getEmail()
    {
        return cust.getEmail();
    }
    
    public String getPassword()
    {
        return cust.getPassword();
    }
    
    public String getPhone()
    {
        return cust.getPhoneNr();
    }
    
    public String getSeqQuest()
    {
        return cust.getSeqQuest();
    }
    
    public String getAddress()
    {
        return cust.getAddress();
    }
}
