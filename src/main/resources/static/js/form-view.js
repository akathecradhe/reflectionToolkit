$(document).ready(function() {
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    $(document).ready(function () {
        var csrfValue = $("meta[name='_csrf']").attr("content");
        var csrfHeader = $("meta[name='_csrf_header']").attr("content");

        $(".deleteBtn").click(function (e) {
            alert("yay it works");
            if (!confirm('Delete this form?')) {
                return
            }
            var id = document.getElementById("formId").value;
            $.ajax({
                type: "delete",
                url: "/reflectionremove/" + id,
                ajaxOptions: {
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(csrfHeader, csrfValue);
                    }
                },
                success: function (result) {
                    window.location = "/reflection/user";
                }
            });
        });
    });
});