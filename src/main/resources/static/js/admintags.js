/**
 * Worked on by Tom
 */
$(document).ready(function(){
    $.ajaxSetup({
        headers: {
            'X-CSRF-TOKEN': $('meta[name="_csrf"]').attr('content')
        }
    });
    $(".deleteBtn").click(function(e){
        if(!confirm('Delete this tag?')) {
            return
        }
        var id = e.target.id;
        $.ajax({type: "delete",
            url: "/deletetag/"+ id,
            success:function(result){
                window.location.replace("/admin/edit-tags");
            }
        });
    });

});