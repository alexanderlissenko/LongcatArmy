/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {

    //alert("Sidan laddar nu... Det är kuul...");

    var nav1 = new Navigator(site.getCustomerCatalogue());
    var nav2 = new Navigator(site.getAuctionCatalogue());

    //$(".test-a tbody").remove();

    $("table#customers").ready(function() {
        nav1.prev(createTableC);
    });
    
    $("table#auctionobjects").ready(function() {
        nav1.prev(createTableA);
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
        alert("customer next")
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
        alert("customer prev")
        nav1.prev(createTableC, fail);
        function fail() {
            createErrorDialog("Can't list!!").dialog("open");
        }
    });
});

// Utils
function createTableA(auctionobjects) {
    
    //alert("hej")
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
        var selectedProductRow = {};
        selectedProductRow.id = $(this).find('td').eq(0).html();
        selectedProductRow.title = $(this).find('td').eq(1).html();
        selectedProductRow.info = $(this).find('td').eq(2).html();
        selectedProductRow.price = $(this).find('td').eq(3).html();
        selectedProductRow.expire = $(this).find('td').eq(4).html();
        createEditDeleteDialogA(selectedProductRow);
    });
}

function createTableC(customers) {
    
    $("#customers tbody tr").remove();
    for (var i = 0; i < customers.length; i++) {
        $("#customers tbody").append('<tr>' +
                '<td>' + customers[i].id + '</td>' +
                '<td>' + customers[i].email + '</td>' +
                '<td>' + customers[i].name + '</td>' +
                '<td>' + customers[i].pass + '</td>' +
                '<td>' + customers[i].phone + '</td>' +
                '<td>' + customers[i].seQuest + '</td>' +
                '<td>' + customers[i].address + '</td>' +
                '</tr>');
    }
    $('table#customers').find('tr')
            .on('click', function() {
        var selectedProductRow = {};
        selectedProductRow.id = $(this).find('td').eq(0).html();
        selectedProductRow.email = $(this).find('td').eq(1).html();
        selectedProductRow.name = $(this).find('td').eq(2).html();
        selectedProductRow.pass = $(this).find('td').eq(3).html();
        selectedProductRow.phone = $(this).find('td').eq(4).html();
        selectedProductRow.seQuest = $(this).find('td').eq(5).html();
        selectedProductRow.address = $(this).find('td').eq(6).html();
        createEditDeleteDialogC(selectedProductRow);
    });
}

function createEditDeleteDialogA(auctionobject) {
    $("#dialog-form").dialog({
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
    $('#dialog-form').dialog(setFormDialogDataA(auctionobject));
    return $('#dialog-form');
}

function createEditDeleteDialogC(customer) {
    $("#dialog-form").dialog({
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
    $('#dialog-form').dialog(setFormDialogDataC(customer));
    return $('#dialog-form');
}

function createConfirmDeleteDialogA(auctionobject) {

    $("#dialog-message").dialog({
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
    $("#dialog-form").dialog(clearFormDialogDataA());
    return $('#dialog-message');
}

function createConfirmDeleteDialogC(customer) {

    $("#dialog-message").dialog({
        autoOpen: true,
        modal: true,
        stack: true,
        buttons: {
            Yes: function() {
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
    auctionobject.id = $("#dialog-form #id").val();
    auctionobject.title = $("#dialog-form #atitle").val();
    auctionobject.info = $("#dialog-form #ainfo").val();
    auctionobject.price = $("#dialog-form #aprice").val();
    auctionobject.expire = $("#dialog-form #aexpire").val();
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
    $("#dialog-form #id").val(auctionobject.id);
    $("#dialog-form #atitle").val(auctionobject.title);
    $("#dialog-form #ainfo").val(auctionobject.info);
    $("#dialog-form #aprice").val(auctionobject.price);
    $("#dialog-form #aexpire").val(auctionobject.expire);
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