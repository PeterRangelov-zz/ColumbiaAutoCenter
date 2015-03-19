$(document).ready(function(){
    $('#phoneNumber').formance('format_phone_number');

    console.log(location.hostname)

    if (location.hostname == "localhost") {
        $('#firstName').val("first name");
        $('#lastName').val("last name");
        $('#phoneNumber').val("1234567890");
        $('#emailAddress').val("peter.rangelov11@gmail.com");
        $('#date1').val("5/5/2015");
        $('#time1').val("9am");
        $('#date2').val("7/5/2015");
        $('#time2').val("10am");
        $('#date3').val("8/5/2015");
        $('#time3').val("11am");
        $('#time3').val("11am");
        $('#vehicle').val("2009 Toyota Corolla");
        $('#appointmentReason').val("Brake Inspection");
        $('#comments').val("Some comments");
    }

});