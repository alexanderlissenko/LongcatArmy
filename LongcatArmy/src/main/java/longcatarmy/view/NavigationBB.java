/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.view;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * Inspiration: http://www.itcuties.com/j2ee/jsf-2-login-filter-example/
 * @author Alexander Lissenko
 */
@ManagedBean
@SessionScoped
public class NavigationBB implements Serializable{
    
    public String redirectToLogin() {
        return "/login.xhtml?faces-redirect=true";
    }
    
    public String toLogin() {
        return "/login.xhtml";
    }
    
    public String redirectToUserLIV() {
        return "/userLoggedInView2.xhtml?faces-redirect=true";
    }
    
    public String toUserLIV() {
        return "/userLoggedInView2.xhtml";
    }
}
