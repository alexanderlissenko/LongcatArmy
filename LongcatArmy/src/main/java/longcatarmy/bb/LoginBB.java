/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import longcatarmy.src.Customer;

/**
 *  A bean for login functionality
 * 
 * Inspiration: http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
 * 
 * @author Alexander Lissenko
 */
@ManagedBean
@SessionScoped
public class LoginBB implements Serializable{
    
    private String username;
    private String password;
    private boolean loggedIn;
    
    private NavigationBB navigationBean;
    
    
    
    //TODO **********************************************************
    public String doLogin() {
        //get all users from database
        
        /*
         * if name=username && password==password
         *      loggedIn = true;
         *      return NavigationBB.redirectToWelcome();    //alternativt redirect to userLoggedInView
         */
        
        FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return navigationBean.toLogin();
    }
    
    public String doLogout() {
        loggedIn = false;
        
        //var hamnar logout message?? definierat i en xhtml-fil??
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG"); 
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        return navigationBean.toLogin();
    }
    
    
    public String getUsername(Customer user) {
        username = user.getName();
        return username;
    }
    
    public String getPassword(Customer user) {
        password = user.getPassword();
        return password;
    }
    
    
}
