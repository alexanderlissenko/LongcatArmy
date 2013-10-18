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
            return $.getJSON(this.baseUri + "/range?" + "first=" + first + "&" + "last=" + last);
        },
        
        getCount: function() {
            return $.getJSON(this.baseUri + "/count");
        },

        editAuction: function(auctionObject) {
            return $.ajax({
                type: 'PUT',
                url: this.baseUri + "/" + auctionObject.id ,
                data: "name=" + auctionObject.name + "&info=" + auctionObject.info +
                        "&price=" + auctionObject.price
            });
        },
                
        deleteAuction: function(id) {
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + id
            });
        }
    };
}());
