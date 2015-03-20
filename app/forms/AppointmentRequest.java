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
//        email.addBcc("peter.rangelov11@gmail.com");
        email.setFrom("appointments@columbiaautocenter.net");
        email.setSubject("New Appointment Request from Website: "+firstName);

        String emailBody = String.format("<table>" +
                "<tr>" +
                    "<td>First Name</td> <td>%s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Last Name</td> <td>%s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Phone Number</td> <td>%s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Email Address</td> <td>%s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Appointment Time (Choice 1)</td> <td>%s - %s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Appointment Time (Choice 2)</td> <td>%s - %s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Appointment Time (Choice 3)</td> <td>%s - %s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Vehicle Year, Make, Model</td> <td>%s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Appointment Reason</td> <td>%s</td>" +
                "</tr>" +

                "<tr>" +
                "<td>Additional Comments</td> <td>%s</td>" +
                "</tr>" +


                "</table>", firstName, lastName, phoneNumber, emailAddress, date1, time1, date2, time2, date3, time3, vehicle, appointmentReason, comments);


        email.setHtml(emailBody);

        try {
            SendGrid.Response response = sendgrid.send(email);
            System.out.println(response.getMessage());
        }
        catch (SendGridException e) {
            System.err.println(e);
        }

    }
}
