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
                    '<td>' + auctionobjects[i].title + '</td>' +
                    '<td>' + auctionobjects[i].info + '</td>' +
                    '<td>' + auctionobjects[i].price + '</td>' +
                    '<td>' + auctionobjects[i].expire + '</td>' +
                    '</tr>');
        }
        $('table#auctionobjects').find('tr')
            .on('click', function() {
                var selectedAuctionRow = {};
                selectedAuctionRow.id = $(this).find('td').eq(0).html();
                selectedAuctionRow.title = $(this).find('td').eq(1).html();
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
            selectedCustomerRow.pass = $(this).find('td').eq(3).html();
            selectedCustomerRow.phone = $(this).find('td').eq(4).html();
            selectedCustomerRow.seQuest = $(this).find('td').eq(5).html();
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
                        createConfirmDeleteDialogA(auctionobject);
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
                        createConfirmDeleteDialogC(customer);
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

    function createConfirmDeleteDialogA(auctionobject) {

        $("#dialog-form-A").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Yes: function() {
                    $(this).dialog(site.getAuctionCatalogue().remove(auctionobject.id)); //ej asynkront!!
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

    function createConfirmDeleteDialogC(customer) {

        $("#dialog-message").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Yes: function() {
                    //remove funkar ej!
                    $(this).dialog(site.getCustomerCatalogue().remove(customer.id)); //ej asynkront!!
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-message').dialog('option', 'title', 'Are you sure?');
        $("#dialog-message #msg").text("Do you really want to delete this customer?");
        $("#dialog-form").dialog(clearFormDialogDataC());
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
        auctionobject.title = $("#dialog-form-A #atitle").val();
        auctionobject.info = $("#dialog-form-A #ainfo").val();
        auctionobject.price = $("#dialog-form-A #aprice").val();
        auctionobject.expire = $("#dialog-form-A #aexpire").val();
        return auctionobject;
    }

    function getFormDialogDataC() {
        var customer = {};
        customer.id = $("#dialog-form #id").val();
        customer.email = $("#dialog-form #cemail").val();
        customer.name = $("#dialog-form #cname").val();
        customer.pass = $("#dialog-form #cpass").val();
        customer.phone = $("#dialog-form #cphone").val();
        customer.seQuest = $("#dialog-form #cseQuest").val();
        customer.address = $("#dialog-form #caddres").val();
        return customer;
    }

    function setFormDialogDataA(auctionobject) {
        $("#dialog-form-A #id").val(auctionobject.id);
        $("#dialog-form-A #atitle").val(auctionobject.title);
        $("#dialog-form-A #ainfo").val(auctionobject.info);
        $("#dialog-form-A #aprice").val(auctionobject.price);
        $("#dialog-form-A #aexpire").val(auctionobject.expire);
    }

    function setFormDialogDataC(customer) {
        $("#dialog-form #id").val(customer.id);
        $("#dialog-form #cemail").val(customer.email);
        $("#dialog-form #cname").val(customer.name);
        $("#dialog-form #cpass").val(customer.pass);
        $("#dialog-form #cphone").val(customer.phone);
        $("#dialog-form #cseQuest").val(customer.seQuest);
        $("#dialog-form #caddress").val(customer.address);
    }

    function clearFormDialogDataA() {
        $("#dialog-form #id").val("");
        $("#dialog-form #atitle").val("");
        $("#dialog-form #ainfo").val("");
        $("#dialog-form #aprice").val("");
        $("#dialog-form #aexpire").val("");
    }

    function clearFormDialogDataC() {
        $("#dialog-form #id").val("");
        $("#dialog-form #cemail").val("");
        $("#dialog-form #cname").val("");
        $("#dialog-form #cpass").val("");
        $("#dialog-form #cphone").val("");
        $("#dialog-form #cseQuest").val("");
        $("#dialog-form #cadress").val("");
    }
});