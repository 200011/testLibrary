jQuery(document).ready(function($) {

    $("#searchForm").submit(function(event) {
        event.preventDefault();

        searchViaAjax();
    });

});

function searchViaAjax() {

    var search = {};
    search["authorName"] = $("#authorName").val();
    search["authorSurname"] = $("#authorSurname").val();
    search["book"] = $("#book").val();

    $.ajax({
        type : "POST",
        contentType: "application/json; charset=UTF-8",
        url : "./search.html",
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
    var output="<ul>";
    for (var i in data)
    {
        output+="<li>" + data[i].author.name  + " " + data[i].author.surname +" - " +  data[i].bookname  + "</li>";
        JSON.stringify(output);
    }
    output+="</ul>";

    $('#searchResult').html(output);
}