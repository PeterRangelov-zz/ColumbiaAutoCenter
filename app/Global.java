import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.Play;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        Logger.info("APPLICATION HAS STARTED");
        Logger.info("SENDGRID USERNAME -> "+Play.application().configuration().getString("sendgrid.username"));
        Logger.info("SENDGRID PASSWORD -> "+Play.application().configuration().getString("sendgrid.password"));
        Logger.info("GOOGLE MAPS API KEY -> "+Play.application().configuration().getString("gmaps.apikey"));
    }

    @Override
    public void onStop(Application app) {
        Logger.info("Application shutdown...");
    }

}