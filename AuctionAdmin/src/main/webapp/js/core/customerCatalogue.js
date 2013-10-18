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
            return $.getJSON(this.baseUri + "/rangeC?" + "first=" + first + "&" + "last=" + last);
        },
        
        getCount: function() {
            return $.getJSON(this.baseUri + "/count");
        },
        
        editCustomer: function(customer) {
            return $.ajax({
                type: 'PUT',
                url: this.baseUri + "/" + customer.id,
                data: "email=" + customer.email + "&name=" + customer.name +
                        "&pass=" + customer.pass + "&phone=" + customer.phone +
                        "&seQuest=" + customer.seQuest + "&address=" +
                        customer.address + "&access=" + customer.access
            });
        },
        deleteCustomer: function(customer) {
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + customer.id
            });
        }
    };
}());
