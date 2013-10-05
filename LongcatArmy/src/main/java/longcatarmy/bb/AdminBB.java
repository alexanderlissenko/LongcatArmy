/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package longcatarmy.bb;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Emelie Svensson
 */
@SessionScoped
@Named("admin")
public class AdminBB {
    
    private AuctionBB auction;
    @Inject
    private void setAuctiom(AuctionBB ab){
        auction = ab;
    }

}
