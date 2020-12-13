$(document).ready(function() {
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    $(document).ready(function () {
        $.ajaxSetup({
            headers: {
                'X-CSRF-TOKEN': $('meta[name="_csrf"]').attr('content')
            }
        });

        $(".deleteBtn").click(function (e) {
            if (!confirm('Delete this form?')) {
                return
            }
            var id = document.getElementById("formId").value;
            $.ajax({
                type: "delete",
                url: "/reflectionremove/" + id,
                success: function (result) {
                    window.location = "/reflection/user";
                }
            });
        });
    });
});