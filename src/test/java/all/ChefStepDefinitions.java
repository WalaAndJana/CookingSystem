package all;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class ChefStepDefinitions {

    // Variables for View assigned cooking tasks
    private String chefName;
    private String assignedTask;
    private String notificationStatus;

    // Variables for Ingredient substitutions
    private String originalIngredient;
    private String substitutedIngredient;
    private String chefApproval;

    // Add these with your other variable declarations at the top
    private String customerName;
    private String dietaryPreference;
    private String allergyInfo;
    private String lastOrderedMeal;



    // ===== View assigned cooking tasks steps =====
    @Given("a chef is logged into the system")
    public void chefIsLoggedIn() {
        System.out.println("Chef is logged into the system");
    }

    @When("they check their task list")
    public void checkTaskList() {
        System.out.printf(
                "%s checks their task list%n", chefName);
    }

    @Then("the system should display all assigned tasks")
    public void displayAssignedTasks() {
        System.out.printf("Displaying task: %s%n", assignedTask);
        Assert.assertNotNull("Task should not be null", assignedTask);
    }

    @And("notify the chef of upcoming cooking deadlines")
    public void notifyUpcomingDeadlines() {
        System.out.printf("Notification sent: %s%n", notificationStatus);
        Assert.assertEquals("Notification should be received", "Yes", notificationStatus);
    }

    // ===== Approve or adjust ingredient substitutions steps =====
    @Given("a customer has selected an alternative ingredient")
    public void customerSelectsAlternative() {
        System.out.printf("Substitution requested: %s -> %s%n",
                originalIngredient, substitutedIngredient);
    }

    @When("the system notifies the chef")
    public void systemNotifiesChef() {
        System.out.println("System notified the chef about substitution");
    }

    @Then("the chef should approve or adjust the recipe")
    public void chefApprovesOrAdjusts() {
        System.out.printf("Chef decision: %s%n", chefApproval);
        Assert.assertTrue("Should be Approved or Adjusted",
                chefApproval.equals("Approved") || chefApproval.equals("Adjusted"));
    }

    // ===== Data injection methods =====
    @Given("the task details:")
    public void setTaskDetails(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        this.chefName = data.get("Chef Name");
        this.assignedTask = data.get("Assigned Tasks");
        this.notificationStatus = data.get("Notification Received");
    }

    @Given("the substitution details:")
    public void setSubstitutionDetails22(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        this.originalIngredient = data.get("Original Ingredient");
        this.substitutedIngredient = data.get("Substituted Ingredient");
        this.chefApproval = data.get("Chef Approval");
    }

    // ===== View customer dietary preferences steps =====
    @Given("a chef wants to customize a meal")
    public void chefWantsToCustomizeMeal() {
        System.out.println("Chef wants to customize a meal");
    }

    @Given("the dietary details:")
    public void setDietaryDetails(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        this.customerName = data.get("Customer Name");
        this.dietaryPreference = data.get("Dietary Preference");
        this.allergyInfo = data.get("Allergy");
        System.out.printf("Loaded dietary info for %s%n", customerName);
    }

    @When("they access a customer's profile")
    public void accessCustomerProfile() {
        System.out.printf("Accessing profile for %s%n", customerName);
    }

    @Then("the system should display the customer's dietary preferences and allergies")
    public void displayDietaryInfo() {
        Assert.assertNotNull("Dietary preference should be displayed", dietaryPreference);
        Assert.assertNotNull("Allergy info should be displayed", allergyInfo);
        System.out.printf("Displaying - Preference: %s, Allergy: %s%n",
                dietaryPreference, allergyInfo);
    }

    // ===== Access customers' order history steps =====
    @Given("a chef wants to suggest a meal plan")
    public void chefWantsToSuggestMealPlan() {
        System.out.println("Chef wants to suggest a meal plan");
    }

    @Given("the order history details:")
    public void setOrderHistoryDetails22(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps().get(0);
        this.customerName = data.get("Customer Name");
        this.lastOrderedMeal = data.get("Last Ordered Meal");
        System.out.printf("Loaded order history for %s%n", customerName);
    }

    @When("they access a customer's order history")
    public void accessOrderHistory() {
        System.out.printf("Accessing order history for %s%n", customerName);
    }

    @Then("the system should display past orders")
    public void displayPastOrders() {
        Assert.assertNotNull("Last ordered meal should be displayed", lastOrderedMeal);
        System.out.printf("Displaying last ordered meal: %s%n", lastOrderedMeal);
    }




}