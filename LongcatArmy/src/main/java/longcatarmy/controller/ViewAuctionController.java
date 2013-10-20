package longcatarmy.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.AuctionObject;
import longcat.auction.src.Customer;
import longcatarmy.src.SuperSiteBean;
import longcatarmy.view.ViewAuctionBB;

@Named
@RequestScoped
public class ViewAuctionController {
    private SuperSiteBean site;

    @Inject
    ViewAuctionBB viewAuctionBB;

    @Inject
    private void setSite(SuperSiteBean site) {
        this.site = site;
    }

    public String onSetBid() {
        final AuctionObject auctionObject = site.getAuctionCatalogue().find(viewAuctionBB.getId());
        Customer cust = site.getCustomerCatalogue().find(Long.parseLong("1"));
        site.doBid(cust, viewAuctionBB.getPrice(), auctionObject);
        //FacesContext.getCurrentInstance().addMessage(null, null);
        
        return "success";
    }
}
