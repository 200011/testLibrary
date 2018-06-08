$(document).ready(function($) {

    $("#addBook-form").submit(function(event) {
        event.preventDefault();

        addViaAjax();
    });

});

function addViaAjax() {

    var search = {};
    search["authorId"] = $("#authorId").val();
    search["book"] = $("#book").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "./rest/addBook.html",
        data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            display(data);
        }
    });
}
function display(data) {
    $('#result_text').html(data.msg);
}
