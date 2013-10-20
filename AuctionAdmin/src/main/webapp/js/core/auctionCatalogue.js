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

        update: function(auctionobject) {
            return $.ajax({
                type: 'PUT',
                url: this.baseUri + "/" + auctionobject.id ,
                data: "name=" + auctionobject.name + "&info=" + auctionobject.info +
                        "&price=" + auctionobject.price
            });
        },
                
        remove: function(id) {
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + id
            });
        }
    };
}());
