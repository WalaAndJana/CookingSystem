package all;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MyApplication {

///////////////log in/////////////////////////////
    private final List<Person> users;
     private String message;
    private boolean validation;
    private boolean Customerlogged;
    private Person loggedInUser;
    private boolean isLoggedIn;
    public MyApplication() {
        users = new ArrayList<>();
        // mock users
        users.add(new Person("wala", "wala123", "customer"));
        users.add(new Person("chef1", "chefpass", "chef"));
        users.add(new Person("user88", "abc123", "kitchenManager"));
    isLoggedIn=false;

    }

    public void setUsernameAndPassAndPassFromSystem(String name, String pass) {
        validation = false;

        message = "";

        if (name.isEmpty() && pass.isEmpty()) {
            message = "Username and password cannot be empty";
            return;
        }

        if (name.isEmpty()) {
            message = "Username cannot be empty";
            return;
        }

        if (pass.isEmpty()) {
            message = "Password cannot be empty";
            return;
        }

        for (Person user : users) {
            if (user.getUserName().equals(name)) {
                if (user.getPass().equals(pass)) {
                    validation = true;
                    loggedInUser = user;
                    return;
                } else {
                    message = "Incorrect password";
                    return;
                }
            }
        }


        message = "User not found";
    }

    public String getLoggedInUserRole() {
        return (loggedInUser != null) ? loggedInUser.getRole() : null;
    }


    public boolean getValidation() {
        return validation;
    }

    public void iAmNotInSystem(MyApplication obj) {
        validation = false;
        loggedInUser = null;
    }



    public String getMessage() {
        return message;
    }

////////////////////////////////////////////////////////////////////////

    public boolean isCustomer() {

        return loggedInUser != null && "customer".equalsIgnoreCase(loggedInUser.getRole());
    }

    public void loginByNameOnly(String name) {
        for (Person user : users) {
            if (user.getUserName().equalsIgnoreCase(name)) {
                loggedInUser = user;
                validation = true;
                return;
            }
        }
        loggedInUser = null;
        validation = false;
    }



    private List<CustomerProfile> customerProfiles = new ArrayList<>();

    public void addCustomerProfile(String name, String preference, String allergy) {
        CustomerProfile customer = new CustomerProfile(name, preference, allergy); // null = لم يُطلب بعد
        if (customer.isValid()) {
            customerProfiles.add(customer);
            System.out.println("✅ Customer added: " + name);
        } else {
            System.out.println("❌ Invalid customer data.");
        }
    }

    public List<CustomerProfile> getCustomerProfiles() {
        return customerProfiles;
    }
    public void addCustomer(CustomerProfile c) {
        if (c != null && c.isValid()) {
            customerProfiles.add(c);
            System.out.println("✅ Customer added: " + c.getName());
        } else {
            System.out.println("❌ Invalid customer object.");
        }
    }


    public CustomerProfile getProfileByName(String name) {
        for (CustomerProfile profile : customerProfiles) {
            if (profile.getName().equalsIgnoreCase(name)) {
                return profile;
            }
        }
        return null;
    }



}
