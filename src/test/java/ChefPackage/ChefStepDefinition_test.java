package ChefPackage;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChefStepDefinition_test {
    private String chefName = "Chef John";
    private String assignedTask = "Prepare risotto";
    private String notificationStatus = "Yes";
//
//    // ===== View assigned cooking tasks steps =====
//    @Given("a chef is logged into the system")
//    public void chefIsLoggedIn() {
//        System.out.println("Chef is logged into the system");
//    }
//
//    @When("they check their task list")
//    public void checkTaskList() {
//        System.out.printf("%s checks their task list%n", chefName);
//    }
//
//    @Then("the system should display all assigned tasks")
//    public void displayAssignedTasks() {
//        System.out.printf("Displaying task: %s%n", assignedTask);
//        Assert.assertNotNull("Task should not be null", assignedTask);
//    }
//
//    @And("notify the chef of upcoming cooking deadlines")
//    public void notifyUpcomingDeadlines() {
//        System.out.printf("Notification sent: %s%n", notificationStatus);
//        Assert.assertEquals("Notification should be received", "Yes", notificationStatus);
//    }
}