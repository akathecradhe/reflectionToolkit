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
    document.getElementById("form").onsubmit = function(){return validate()};


    var activityDate = document.getElementById("eventDate");
    var shortDesc = document.getElementById("shortDesc");


    function validate() {
        if (activityDate.value == ""){
            alert("Missing Date");
            return false;
        } else if (shortDesc.value == ""){
            alert("Missing Description");
            return false;
        } else if ($('input[name="others"]:checked').length == 0) {
            alert("Missing Others Involved Tags");
            return false;
        } else if ($('input[name="impact"]:checked').length == 0) {
            alert("Missing Impact Tags");
            return false;
        } else if ($('input[name="learningTechs"]:checked').length == 0) {
            alert("Missing Learning Technologies Tags");
            return false;
        } else if ($('input[name="thoughtCloud"]:checked').length == 0) {
            alert("Missing Thought Cloud Tags");
            return false;
        } else{
            return confirm("Are you sure you want to submit?");
        }
    }
});
