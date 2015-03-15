package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static Result ourTeam() {
        return TODO;
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


}