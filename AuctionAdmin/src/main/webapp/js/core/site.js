/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var site = (function(){
    
    var baseUri = "http://localhost:8080/AuctionAdmin/";
    var auctionobjects = new AuctionCatalogue(baseUri + "auctionObjects");
    var customers = new CustomerCatalogue(baseUri + "customers");
    
    return {
        getAuctionCatalogue : function() {
            return auctionobjects;
        },
        getCustomerCatalogue : function() {
            return customers;
        },
        getBaseUri : function(){
            return baseUri;
        }
    };
})();
