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
            return 0;
        },
        
        getCount: function() {
            
            return 0;
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
