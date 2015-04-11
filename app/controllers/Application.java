package controllers;

import forms.AppointmentRequest;
import play.*;
import play.data.validation.ValidationError;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import java.util.List;
import java.util.Map;

import static play.data.Form.form;

public class Application extends Controller {
    public static final Form<AppointmentRequest> myForm = form(AppointmentRequest.class);

    public static Result index() {
        return ok(index.render());
    }

    public static Result ourTeam() {
        return ok(team.render());
    }

    public static Result aboutUs() {
        return ok(about.render());
    }

    public static Result contactUs() {
        return ok(contact.render());
    }

    public static Result partsForSale() {
        return TODO;
    }

    public static Result services() {
        return ok(services.render());
    }

    public static Result coupons() {
        return ok(coupons.render());
    }

    public static Result requestAppointment() {
        return ok(request_appointment.render(myForm));
    }

    public static Result thanksForRequestingAppointment() {
        return ok(appointment_thank_you.render());
    }

    public static Result submitAppointmentRequest() {
        System.out.println("method called");

        Form<AppointmentRequest> boundForm = myForm.bindFromRequest();

        AppointmentRequest apptRequest = boundForm.get();

        Logger.info(apptRequest.toString());

        apptRequest.sendEmail();




        return ok(appointment_thank_you.render());
    }
}