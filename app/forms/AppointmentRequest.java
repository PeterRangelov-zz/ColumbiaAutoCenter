package forms;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import lombok.Data;
import play.Logger;
import play.Play;
import play.data.Form;
import play.data.validation.Constraints.*;

/**
 * Created by peterrangelov on 3/18/15.
 */

@Data
public class AppointmentRequest {

    @Required
    public String firstName;
    public String lastName;

    @Required
    public String phoneNumber;

    @Required @Email
    public String emailAddress;

    @Required
    public String date1;

    @Required
    public String time1;


    public String date2;
    public String time2;
    public String date3;
    public String time3;


    @Required
    public String vehicle;

    @Required
    public String appointmentReason;

    public String comments;

    public void sendEmail () {
        System.out.println("Sending email ....");
        String sendgridUsername = Play.application().configuration().getString("sendgrid.username");
        String sendgridPassword = Play.application().configuration().getString("sendgrid.password");

        Logger.info(sendgridUsername);
        Logger.info(sendgridPassword);

        SendGrid sendgrid = new SendGrid(Play.application().configuration().getString("sendgrid.username"), Play.application().configuration().getString("sendgrid.password"));

        SendGrid.Email email = new SendGrid.Email();
        email.addTo(emailAddress);
        email.setFrom("appointments@columbiaautocenter.net");
        email.setSubject("Hello World");
        email.setText("My first email with SendGrid Java!");

        try {
            SendGrid.Response response = sendgrid.send(email);
            System.out.println(response.getMessage());
        }
        catch (SendGridException e) {
            System.err.println(e);
        }

    }
}
