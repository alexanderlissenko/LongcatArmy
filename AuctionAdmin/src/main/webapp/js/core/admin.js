/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var AdminUser = function(baseUri){
    this.baseUri = baseUri;
};


AdminUser.prototype = (function(){
    
    return {
        editCustomer: function (customer){
            return $.ajax({
                type: 'PUT' ,
                url: this.baseUri + "/" + customer.id ,
                data: "email=" + customer.email + "&name=" + customer.name +
                        "&pass=" + customer.pass + "&phone=" + customer.phone +
                        "&seQuest=" + customer.seQuest + "&address=" + 
                        customer.address + "&access=" + customer.access
            });
        },
                
        deleteCustomer: function (customer){
            return $.ajax({
                type: 'DELETE' ,
                url: this.baseUri + "/" + customer.id
            });
        },
        
        editAuction: function (auctionObject){
            return $.ajax({
                type: 'PUT' ,
                url: this.baseUri + "/" + auctionObject.id ,
                data: "title=" + auctionObject.title + "&info=" + auctionObject.info +
                        "&price=" + auctionObject.price
            });
        },
                
        deleteAuction: function (auctionObject){
            return $.ajax({
                type: 'DELETE' ,
                url: this.baseUri + "/" + auctionObject.id
            });
        }
    };
}());