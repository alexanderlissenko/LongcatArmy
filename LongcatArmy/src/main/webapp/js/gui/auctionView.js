/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    
    function createBidDialog(auctionObject) {
        $("#dialog-form").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Place_bid: {
                    text: "Place bid",
                    click: function(){
                        createConfirmBidDialog(auctionObject.bid);
                        $(this).dialog("close");
                    },
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-form').dialog(setFormDialogData(auctionObject));
        return $('#dialog-form');
    }
    
    function createConfirmBidDialog(bid){
        $("#dialog-message").dialog({
            autoOpen: true,
            modal: true,
            stack: true,
            buttons: {
                Yes: function() {
                    $(this).dialog(auctionObject.setBid(bid));
                    $(this).dialog("close");
                },
                Cancel: function() {
                    $(this).dialog("close");
                }
            }
        });
        $('#dialog-message').dialog('option', 'title', 'Are you sure?');
        $("#dialog-message #msg").text("Do you really want to bid " + bid + " on this object?");
        $("#dialog-form").dialog(clearFormDialogData());
        return $('#dialog-message');
    }
    
    function setFormDialogData(auctionObject) {
        $("#dialog-form #bid").val(auctionObject.bid);
    }
    
    function clearFormDialogData() {
        $("#dialog-form #bid").val("");
    }
});
