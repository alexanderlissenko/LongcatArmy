package longcatarmy.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import longcat.auction.src.AuctionObject;
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

    public void onSetBid() {
        final AuctionObject auctionObject = site.getAuctionCatalogue().find(viewAuctionBB.getId());
        auctionObject.setPrice(viewAuctionBB.getPrice());
        site.getAuctionCatalogue().update(auctionObject);
        //FacesContext.getCurrentInstance().addMessage(null, null);
    }
}
