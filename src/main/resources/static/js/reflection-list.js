/**
 * Worked on by Tom
 */
$(document).ready(function () {
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
    $('#myModal').modal('show');
    $("#filters").hide();
    $("#ukpsf").show();
    $("#impact").show();
    $("#ukpsf-drop").hide();
    $("#othersInvolved-drop").hide();
    $("#learningTechnologies-drop").hide();
    $("#thoughtCloud-drop").hide();
    $("#impact-drop").hide();
    $("#completionStatus-drop").hide();
    $("#filterBtn").click(function () {
        $("#filters").toggle()
    });
    $("#ukpsf").click(function () {
        $("#ukpsf-drop").toggle()
    });
    $("#othersInvolved").click(function () {
        $("#othersInvolved-drop").toggle()
    });
    $("#learningTechnologies").click(function () {
        $("#learningTechnologies-drop").toggle()
    });
    $("#thoughtCloud").click(function () {
        $("#thoughtCloud-drop").toggle()
    });
    $("#impact").click(function () {
        $("#impact-drop").toggle()
    });
    $("#completionStatus").click(function () {
        $("#completionStatus-drop").toggle()
    });
});