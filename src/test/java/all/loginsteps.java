package all;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps {


    public loginsteps() {

    }


    @Given("the system is ready for login")
    public void the_system_is_ready_for_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("login should succeed for {string}")
    public void login_should_succeed_for(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user should be redirected to the {string} dashboard")
    public void the_user_should_be_redirected_to_the_dashboard(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("the user enters username {string} and invalid password {string}")
    public void the_user_enters_username_and_invalid_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("login should fail with message {string}")
    public void login_should_fail_with_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters unkown username {string} and password {string}")
    public void the_user_enters_unkown_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @When("the user enters empty username {string} and password {string}")
    public void the_user_enters_empty_username_and_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @When("the user enters username {string} and empty password {string}")
    public void the_user_enters_username_and_empty_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user enters empty username {string} and empty password {string}")
    public void the_user_enters_empty_username_and_empty_password(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
