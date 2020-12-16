
function getData(){
    $.getJSON('http://localhost:8080/api/ukpsfCount', function(results) {
        titles = Object.keys(results);
        values = []
        colours = []
        for (i=0; i < Object.keys(results).length; i++) {
            values.push(results[titles[i]])
            colours.push(getRandomColor())
        };
        addChart();

    });

}

function addChart(){
    console.log(titles);
    console.log(values);
    var ctx = document.getElementById("donut");
    var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: titles,
            datasets: [{
                label: '# of Tag',
                data: values,
                backgroundColor: colours,
                borderWidth: 1
            }]
        },
        options: {
            //cutoutPercentage: 40,
            responsive: true,
            display:true

        }
    });

    var ctx2 = document.getElementById("bigdonut");
    var myChart = new Chart(ctx2, {
        type: 'doughnut',
        data: {
            labels: titles,
            datasets: [{
                label: '# of Tag',
                data: values,
                backgroundColor: colours,
                borderWidth: 1
            }]
        },
        options: {
            //cutoutPercentage: 40,
            responsive: true,
            display:true

        }
    });
}

function getRandomColor() {
    var letters = '0123456789ABCDEF'.split('');
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}



$(document).ready(function () {
    getData();
    });


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