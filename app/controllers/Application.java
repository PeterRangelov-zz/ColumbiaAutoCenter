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
        return TODO;
    }

    public static Result contactUs() {
        return TODO;
    }

    public static Result partsForSale() {
        return TODO;
    }

    public static Result services() {
        return TODO;
    }

    public static Result requestAppointment() {
        return ok(request_appointment.render(myForm));
    }

    public static Result submitAppointmentRequest() {
        System.out.println("method called");

        Form<AppointmentRequest> boundForm = myForm.bindFromRequest();

        AppointmentRequest apptReq = boundForm.get();

        // ERROR CHECK
        if (boundForm.hasErrors()) {
            Map<String, List<ValidationError>> errors = boundForm.errors();
            Logger.info(errors.size() + " ERRORS FOUND!");


            for (String e: errors.keySet()) {
                Logger.info(e);
            }
//            for (ValidationError e : errors.values()) {
//                Logger.info(e.toString());
//            }

            flash("error", "Please correct the form below.");

            return badRequest(request_appointment.render(boundForm));
        }
        else {
            Logger.info("NO ERRORS FOUND!");
            apptReq.sendEmail();
        }


//        AppointmentRequest apptRequest = f.get();




//        System.out.println(apptRequest);
        return TODO;
    }
}