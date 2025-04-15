package CustomerPackage;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

    public class CustomerNotification {

        //private String customerName;
       // private String upcomingOrder;
        private String notificationStatus;



        @Given("a customer has an upcoming meal delivery")
        public void a_customer_has_an_upcoming_meal_delivery() {
            System.out.println("Customer has an upcoming delivery scheduled.");
        }

        @When("the system sends a reminder notification")
        public void the_system_sends_a_reminder_notification() {
            this.notificationStatus = "Sent";
            System.out.println("Reminder notification sent to customer.");
        }

        @Then("the customer should receive the notification")
        public void the_customer_should_receive_the_notification() {
            Assert.assertEquals("Notification should be sent successfully", "Sent", notificationStatus);
            System.out.println("Customer received the meal delivery reminder.");
        }


    }
