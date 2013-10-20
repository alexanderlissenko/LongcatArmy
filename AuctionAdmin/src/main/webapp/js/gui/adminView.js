/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {

    var nav1 = new Navigator(site.getCustomerCatalogue());
    alert("nav1 init")
    var nav2 = new Navigator(site.getAuctionCatalogue());
    alert("nav2 init")

    $("table#auctionobjects").ready(function() {
        nav2.prev(createTableA);
    });
    
    $("table#customers").ready(function() {
        nav1.prev(createTableC); 
    });
    
    

    $("#next-auction-button")
            .button()
            .click(function() {
        nav2.next(createTableA, fail);
        function fail() {
            createErrorDialog("Can't list!!").dialog("open")
        }
    });

    $("#next-customer-button")
            .button()
            .click(function() {
        nav1.next(createTableC, fail);
        function fail() {
            createErrorDialog("Can't list!").dialog("open");
        }
    });

    $("#prev-auction-button")
            .button()
            .click(function() {
        nav2.prev(createTableA, fail);
        function fail() {
            createErrorDialog("Can't list!!").dialog("open");
        }
    });

    $("#prev-customer-button")
            .button()
            .click(function() {
        nav1.prev(createTableC, fail);
        function fail() {
            createErrorDialog("Can't list!!").dialog("open");
        }
    });


    // Utils
    function createTableA(auctionobjects) {
        $("table#auctionobjects tbody tr").remove();
        for (var i = 0; i < auctionobjects.length; i++) {
            $("#auctionobjects tbody").append('<tr>' +
                    '<td>' + auctionobjects[i].id + '</td>' +
                    '<td>' + auctionobjects[i].name + '</td>' +
                    '<td>' + auctionobjects[i].info + '</td>' +
                    '<td>' + auctionobjects[i].price + '</td>' +
                    '<td>' + auctionobjects[i].expire + '</td>' +
                    '</tr>');
        }
        $('table#auctionobjects').find('tr')
            .on('click', function() {
                var selectedAuctionRow = {};
                selectedAuctionRow.id = $(this).find('td').eq(0).html();
                selectedAuctionRow.name = $(this).find('td').eq(1).html();
                selectedAuctionRow.info = $(this).find('td').eq(2).html();
                selectedAuctionRow.price = $(this).find('td').eq(3).html();
                selectedAuctionRow.expire = $(this).find('td').eq(4).html();
                createEditDeleteDialogA(selectedAuctionRow);
            });
    }

    function createTableC(customers) {

        $("table#customers tbody tr").remove();
        for (var i = 0; i < customers.length; i++) {
            $("#customers tbody").append('<tr>' +
                    '<td>' + customers[i].id + '</td>' +
                    '<td>' + customers[i].email + '</td>' +
                    '<td>' + customers[i].name + '</td>' +
                    '<td>' + customers[i].password + '</td>' +
                    '<td>' + customers[i].phoneNr + '</td>' +
                    '<td>' + customers[i].seqQuest + '</td>' +
                    '<td>' + customers[i].address + '</td>' +
                    '</tr>');
        }
        $('table#customers').find('tr')
                .on('click', function() {
            var selectedCustomerRow = {};
            selectedCustomerRow.id = $(this).find('td').eq(0).html();
            selectedCustomerRow.email = $(this).find('td').eq(1).html();
            selectedCustomerRow.name = $(this).find('td').eq(2).html();
            selectedCustomerRow.password = $(this).find('td').eq(3).html();
            selectedCustomerRow.phoneNr = $(this).find('td').eq(4).html();
            selectedCustomerRow.seqQuest = $(this).find('td').eq(5).html();
            selectedCustomerRow.address = $(this).find('td').eq(6).html();
            createEditDeleteDialogC(selectedCustomerRow);
        });
    }

    function createEditDeleteDialogA(auctionobject) {
        $("#dialog-form-A").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Delete: {
                    text: "Delete",
                    click: function() {
                        createConfirmDeleteDialogA(auctionobject.id);
                        $(this).dialog("close");
                    },
                },
                Edit: {
                    text: "Edit",
                    click: function() {
                        var tmpObj = getFormDialogDataA();
                        $(this).dialog(site.getAuctionCatalogue().update(tmpObj));
                        $(this).dialog("close");
                    },
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-form-A').dialog(setFormDialogDataA(auctionobject));
        return $('#dialog-form-A');
    }

    function createEditDeleteDialogC(customer) {
        $("#dialog-form-C").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Delete: {
                    text: "Delete",
                    click: function() {
                        createConfirmDeleteDialogC(customer.id);
                        $(this).dialog("close");
                    },
                },
                Edit: {
                    text: "Edit",
                    click: function() {
                        var tmpCust = getFormDialogDataC();
                        $(this).dialog(site.getCustomerCatalogue().update(tmpCust));
                        $(this).dialog("close");
                    },
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-form-C').dialog(setFormDialogDataC(customer));
        return $('#dialog-form-C');
    }

    function createConfirmDeleteDialogA(id) {

        $("#dialog-message").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Yes: function() {
                    $(this).dialog(site.getAuctionCatalogue().remove(id)); //ej asynkront!!
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-message').dialog('option', 'title', 'Are you sure?');
        $("#dialog-message #msg").text("Do you really want to delete this Auction?");
        $("#dialog-form-A").dialog(clearFormDialogDataA());
        return $('#dialog-message');
    }

    function createConfirmDeleteDialogC(id) {

        $("#dialog-message").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Yes: function() {
                    //remove funkar ej!
                    $(this).dialog(site.getCustomerCatalogue().remove(id)); //ej asynkront!!
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-message').dialog('option', 'title', 'Are you sure?');
        $("#dialog-message #msg").text("Do you really want to delete this customer?");
        $("#dialog-form-C").dialog(clearFormDialogDataC());
        return $('#dialog-message');
    }

    function createErrorDialog(message) {

        $("#dialog-message").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Ok: function() {
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-message').dialog('option', 'title', 'Something went! wrong');
        $("#dialog-message #msg").text(message);
        return $('#dialog-message');
    }

    function getFormDialogDataA() {
        var auctionobject = {};
        auctionobject.id = $("#dialog-form-A #id").val();
        auctionobject.name = $("#dialog-form-A #aname").val();
        auctionobject.info = $("#dialog-form-A #ainfo").val();
        auctionobject.price = $("#dialog-form-A #aprice").val();
        auctionobject.expire = $("#dialog-form-A #aexpire").val();
        return auctionobject;
    }

    function getFormDialogDataC() {
        var customer = {};
        customer.id = $("#dialog-form-C #id").val();
        customer.email = $("#dialog-form-C #cemail").val();
        customer.name = $("#dialog-form-C #cname").val();
        customer.password = $("#dialog-form-C #cpass").val();
        customer.phoneNr = $("#dialog-form-C #cphone").val();
        customer.seqQuest = $("#dialog-form-C #cseqQuest").val();
        customer.address = $("#dialog-form-C #caddress").val();
        return customer;
    }

    function setFormDialogDataA(auctionobject) {
        $("#dialog-form-A #id").val(auctionobject.id);
        $("#dialog-form-A #aname").val(auctionobject.name);
        $("#dialog-form-A #ainfo").val(auctionobject.info);
        $("#dialog-form-A #aprice").val(auctionobject.price);
        $("#dialog-form-A #aexpire").val(auctionobject.expire);
    }

    function setFormDialogDataC(customer) {
        $("#dialog-form-C #id").val(customer.id);
        $("#dialog-form-C #cemail").val(customer.email);
        $("#dialog-form-C #cname").val(customer.name);
        $("#dialog-form-C #cpass").val(customer.password);
        $("#dialog-form-C #cphone").val(customer.phoneNr);
        $("#dialog-form-C #cseqQuest").val(customer.seqQuest);
        $("#dialog-form-C #caddress").val(customer.address);
    }

    function clearFormDialogDataA() {
        $("#dialog-form-A #id").val("");
        $("#dialog-form-A #aname").val("");
        $("#dialog-form-A #ainfo").val("");
        $("#dialog-form-A #aprice").val("");
        $("#dialog-form-A #aexpire").val("");
    }

    function clearFormDialogDataC() {
        $("#dialog-form-C #id").val("");
        $("#dialog-form-C #cemail").val("");
        $("#dialog-form-C #cname").val("");
        $("#dialog-form-C #cpass").val("");
        $("#dialog-form-C #cphone").val("");
        $("#dialog-form-C #cseqQuest").val("");
        $("#dialog-form-C #caddress").val("");
    }
});