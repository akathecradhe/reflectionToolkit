$(function(){
    var actionsRequired = $('.actionPoints :checkbox[required]');
    actionsRequired.change(function(){
        if(actionsRequired.is(':checked')) {
            actionsRequired.removeAttr('required');
        } else {
            actionsRequired.attr('required', 'required');
        }
    });
});