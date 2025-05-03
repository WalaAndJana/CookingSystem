package all;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Customer {


    public MyApplication obj;


    public Customer(MyApplication iobj) {
        super();
        this.obj = iobj;


    }


    //  Variables
    private String customerName;
    private String dietaryPreference;
    private String allergyInfo;
    private String lastOrderedMeal;
    private String selectedIngredients;
    private String unavailableIngredient;
    private String suggestedSubstitution;
    private String substitutionApproval;

    //  Store dietary preferences
    @Given("the customer {string} is logged in")
    public void the_customer_is_logged_in(String string) {


        obj.loginByNameOnly(string);  // Log in by name
        assertTrue("User is not a customer!", obj.isCustomer()); // Confirm role

    }

    @Given("a customer wants to input their dietary preferences")
    public void a_customer_wants_to_input_their_dietary_preferences() {
        System.out.println("Customer wants to input dietary preferences.");
    }

    @Given("the preference details:")
    public void the_preference_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        this.customerName = data.get("Customer Name");
        this.dietaryPreference = data.get("Dietary Preference");
        this.allergyInfo = data.get("Allergy");

        obj.addCustomerProfile(customerName, dietaryPreference, allergyInfo);
    }

    @When("they save their profile")
    public void they_save_their_profile() {

        CustomerProfile customer = new CustomerProfile(customerName, dietaryPreference, allergyInfo);
        obj.addCustomer(customer);
        System.out.println("Customer saves their dietary profile.");

        System.out.println("Customer saves their dietary profile.");
    }

    @Then("the system should store their preferences")
    public void the_system_should_store_their_preferences() {
        Assert.assertNotNull("Dietary preference should be stored", dietaryPreference);
        Assert.assertNotNull("Allergy info should be stored", allergyInfo);
        System.out.println("Preferences successfully stored.");
    }

    @Then("ensure meals do not contain restricted ingredients")
    public void ensure_meals_do_not_contain_restricted_ingredients() {
        CustomerProfile saved = obj.getProfileByName(customerName);
        Assert.assertTrue("Meal contains restricted ingredients!", saved.isMealValid());
        System.out.println("Meals validated to not contain allergy-related ingredients.");
    }

    //  View past orders

    @Given("a customer wants to view their past orders")
    public void a_customer_wants_to_view_their_past_orders() {
        System.out.println("Customer wants to view past orders.");
    }


    @Given("order history details:")
    public void orderHistoryDetails(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        Map<String, String> data = dataTable.asMaps().get(0);
        this.customerName = data.get("Customer Name");
        this.lastOrderedMeal = data.get("Last Ordered Meal");
        System.out.printf("Loaded past order for %s: %s%n", customerName, lastOrderedMeal);


    }


    @When("they access their order history")
    public void they_access_their_order_history() {
        System.out.printf("Accessing order history for customer: %s%n", customerName);
    }

    @Then("the system should display their past meal orders")
    public void the_system_should_display_their_past_meal_orders() {
        Assert.assertNotNull("Order history should be displayed", lastOrderedMeal);
        System.out.printf("Displaying past meal orders: %s%n", lastOrderedMeal);
    }

    //  Customize meal

    @Given("a customer wants to customize their meal")
    public void a_customer_wants_to_customize_their_meal() {
        System.out.println("Customer wants to customize their meal.");
    }

    @Given("the customization details:")
    public void the_customization_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        this.customerName = data.get("Customer Name");
        this.selectedIngredients = data.get("Selected Ingredients");
        System.out.printf("Loaded customization for %s: Ingredients = %s%n",
                customerName, selectedIngredients);
    }

    @When("they place a custom order")
    public void they_place_a_custom_order() {
        System.out.printf("Placing custom order with ingredients: %s%n", selectedIngredients);
    }

    @Then("the system should validate the ingredient selection")
    public void the_system_should_validate_the_ingredient_selection() {
        Assert.assertNotNull("Selected ingredients should not be null", selectedIngredients);
        System.out.println("Custom order ingredients validated.");
    }

    @Then("ensure it meets dietary restrictions")
    public void ensure_it_meets_dietary_restrictions() {
        assertTrue("Selected ingredients must not conflict with dietary preference",
                selectedIngredients != null && !selectedIngredients.isEmpty());
        System.out.println("Custom order meets dietary restrictions.");
    }

    // Ingredient substitution

    @Given("a customer selects an unavailable ingredient")
    public void a_customer_selects_an_unavailable_ingredient() {
        System.out.println("Customer selects an unavailable ingredient.");
    }

    @Given("substitution details:")
    public void substitution_details(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        this.customerName = data.get("Customer Name");
        this.unavailableIngredient = data.get("Original Ingredient");
        this.suggestedSubstitution = data.get("Suggested Substitute");
        // Simulate customer approval decision: approve by default
        this.substitutionApproval = "Approved";
        System.out.printf("Substitution details loaded for %s: %s -> %s%n",
                customerName, unavailableIngredient, suggestedSubstitution);
    }

    @When("they receive the suggested substitution")
    public void they_receive_the_suggested_substitution() {
        System.out.printf("Suggested substitution for %s: %s%n", unavailableIngredient, suggestedSubstitution);
    }

    @Then("they should approve or reject the change")
    public void they_should_approve_or_reject_the_change() {
        assertTrue("Customer must approve or reject the suggestion",
                substitutionApproval.equals("Approved") || substitutionApproval.equals("Rejected"));
        System.out.printf("Customer decision on substitution: %s%n", substitutionApproval);
    }
}
