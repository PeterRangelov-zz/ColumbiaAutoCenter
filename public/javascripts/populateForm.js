$(document).ready(function(){
    $('#datetime1').datetimepicker({
        formatDate:'mm/dd/yyyy'
    });
    $('#datetime2').datetimepicker({
        formatDate:'mm/dd/yyyy'
    });
    $('#datetime3').datetimepicker({
        formatDate:'mm/dd/yyyy'
    });
    $('#phoneNumber').formance('format_phone_number');

    console.log(location.hostname)

    if ( location.hostname == "localhost") {
        $('#firstName').val("first name");
        $('#lastName').val("last name");
        $('#phoneNumber').val("1234567890");
        $('#emailAddress').val("peter.rangelov11@gmail.com");
        $('#datetime1').val("2015/03/19 13:00");
        $('#datetime2').val("2015/03/20 13:00");
        $('#datetime3').val("2015/03/21 13:00");
        $('#vehicle').val("2009 Toyota Corolla");
        $('#appointmentReason').val("Brake Inspection");
        $('#comments').val("Some comments");
    }

});