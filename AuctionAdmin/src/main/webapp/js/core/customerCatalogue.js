/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var CustomerCatalogue = function(baseUri) {
    this.baseUri = baseUri;
};

CustomerCatalogue.prototype = (function() {

    return {
                
        getRange: function(first, last) {
            return $.getJSON(this.baseUri + "/range?" + "first=" + first + "&" + "last=" + last);
        },
        
        getCount: function() {
            return $.getJSON(this.baseUri + "/count");
        },
        
        update: function(customer) {
            return $.ajax({
                type: 'PUT',
                url: this.baseUri + "/" + customer.id,
                data: "email=" + customer.email + "&name=" + customer.name +
                        "&password=" + customer.password + "&phoneNr=" + customer.phoneNr +
                        "&seqQuest=" + customer.seqQuest + "&address=" + customer.address
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
