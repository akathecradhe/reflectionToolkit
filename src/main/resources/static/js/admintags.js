$(document).ready(function(){
    $(".deleteBtn").click(function(e){
        if(!confirm('Delete this form?')) {
            return
        }
        var id = e.target.id;
        $.ajax({type: "delete",
            url: "/deletetag/"+ id,
            success:function(result){
                window.location.reload();
            }
        });
    });
});