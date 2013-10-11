/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var AuctionObject = function(baseUri) {
    this.baseUri = baseUri;
};

AuctionObject.prototype = (function() {
    
    return {
        getTitle: function() {
            return $.getJSON(this.baseUri + "/title");
        },
                
        getInfo: function() {
            return $.getJSON(this.baseUri + "/info");
        },
                
        getPrice: function() {
            return $.getJSON(this.baseUri + "/price");
        },
                
        getExpire: function() {
            return $.getJSON(this.baseUri + "/expire");
        },
                
        getBidder: function() {
            return $.getJSON(this.baseUri + "/bidder");
        },
                
        getFlagList: function() {
            return $.getJSON(this.baseUri + "/flags");
        }
    };
}());
