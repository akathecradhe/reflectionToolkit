$(document).ready(function() {
    function menuSelect(element) {
        document.getElementById('activitydetails').style.display = 'none'
        document.getElementById('ukpsf').style.display = 'none';
        document.getElementById('thoughtcld').style.display = 'none';
        document.getElementById('impact').style.display = 'none';
        document.getElementById(element).style.display = 'block';
        document.documentElement.scrollTop = 0;
    }

    function uncheck(checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6) {
        let checkBox = document.getElementById("None");
        if (checkBox.checked == true) ;
        {
            document.getElementById(checkbox1).checked = false;
            document.getElementById(checkbox2).checked = false;
            document.getElementById(checkbox3).checked = false;
            document.getElementById(checkbox4).checked = false;
            document.getElementById(checkbox5).checked = false;
            document.getElementById(checkbox6).checked = false;
        }
    }

    function uncheckNone() {
        document.getElementById('None').checked = false;
    }

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })

    $('.navbar-collapse a').click(function () {
        $(".navbar-collapse").collapse('hide');
    });

// Code adapted from https://stackoverflow.com/questions/6218494/using-the-html5-required-attribute-for-a-group-of-checkboxes
    $(function () {
        var othersRequired = $('.othersInvolved :checkbox[required]');
        othersRequired.change(function () {
            if (othersRequired.is(':checked')) {
                othersRequired.removeAttr('required');
            } else {
                othersRequired.attr('required', 'required');
            }
        });
    });

    $(function () {
        var impactRequired = $('.impact :checkbox[required]');
        impactRequired.change(function () {
            if (impactRequired.is(':checked')) {
                impactRequired.removeAttr('required');
            } else {
                impactRequired.attr('required', 'required');
            }
        });
    });


    $(function () {
        var learningRequired = $('.learningTechnology :checkbox[required]');
        learningRequired.change(function () {
            if (learningRequired.is(':checked')) {
                learningRequired.removeAttr('required');
            } else {
                learningRequired.attr('required', 'required');
            }
        });
    });

    $(function () {
        var thoughtRequired = $('.thoughtCloud :checkbox[required]');
        thoughtRequired.change(function () {
            if (thoughtRequired.is(':checked')) {
                thoughtRequired.removeAttr('required');
            } else {
                thoughtRequired.attr('required', 'required');
            }
        });
    });

    document.getElementById("activityNext").onclick = function () {
        document.getElementById('activitydetails').style.display = 'none';
        document.getElementById('ukpsf').style.display = 'block';
        document.documentElement.scrollTop = 0;
    };
    document.getElementById("activityTitle").onclick = function () {
        menuSelect('activitydetails')
    };
    document.getElementById("ukpsfTitle").onclick = function () {
        menuSelect('ukpsf')
    };
    document.getElementById("impactTitle").onclick = function () {
        menuSelect('impact')
    };
    document.getElementById("thoughtTitle").onclick = function () {
        menuSelect('thoughtcld')
    };
    document.getElementById("submitTitle").onclick = function () {
        document.getElementById('submitBtn').click();
    };
    document.getElementById("ukpsfBack").onclick = function () {
        document.getElementById('ukpsf').style.display = 'none';
        document.getElementById('activitydetails').style.display = 'block';
        document.documentElement.scrollTop = 0;
    };
    document.getElementById("ukpsfNext").onclick = function () {
        document.getElementById('ukpsf').style.display = 'none';
        document.getElementById('impact').style.display = 'block';
        document.documentElement.scrollTop = 0;
    };
    document.getElementById("impactBack").onclick = function () {
        document.getElementById('ukpsf').style.display = 'block';
        document.getElementById('impact').style.display = 'none';
        document.documentElement.scrollTop = 0;
    };
    document.getElementById("impactNext").onclick = function () {
        document.getElementById('impact').style.display = 'none';
        document.getElementById('thoughtcld').style.display = 'block';
        document.documentElement.scrollTop = 0;
    };
    document.getElementById("thoughtBack").onclick = function () {
        document.getElementById('thoughtcld').style.display = 'none';
        document.getElementById('impact').style.display = 'block';
        document.documentElement.scrollTop = 0;
    };
});