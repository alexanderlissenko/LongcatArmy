/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var AuctionCatalogue = function(baseUri) {
    this.baseUri = baseUri;
};

AuctionCatalogue.prototype = (function() {

    return {
        
        getRange: function(first, last) {
            return 0;
        },
        
        getCount: function() {
            
            return 0;
        },

        editAuction: function(auctionObject) {
            return $.ajax({
                type: 'PUT',
                url: this.baseUri + "/edit/" + auctionObject.id,
                data: "title=" + auctionObject.title + "&info=" + auctionObject.info +
                        "&price=" + auctionObject.price
            });
        },
        deleteAuction: function(auctionObject) {
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + auctionObject.id
            });
        }
    };
}());
