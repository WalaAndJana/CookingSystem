package all;

import java.util.*;

public class MyApplication {

    ///////////////log in/////////////////////////////
    private final List<Person> users;
    public static List<chef> chefs = new ArrayList<>(); // array of ches
    public static List<Manager> managers = new ArrayList<>(); // array of managers
    public static List<Ingredient> ingredients = new ArrayList<>(); // array of ingredients
    public static List<Supplier> suppliers = new ArrayList<>(); // array of suppliers


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


        chefs.add(new chef("chef1", "grilling","chef1pass", "chef"));
        chefs.add(new chef("chef2", "vegan","chef2pass", "chef"));
        chefs.add(new chef("chef3", "baking","chef3pass", "chef"));

        managers.add(new Manager("manager1", "manager1pass", "manager"));
        managers.add(new Manager("manager2", "manager2pass", "manager"));
        managers.add(new Manager("manager3", "manager3pass", "manager"));

        // 🥦 Mock ingredients
        ingredients.add(new Ingredient("Tomato", 20, 10));
        ingredients.add(new Ingredient("Cheese", 5, 8));
        ingredients.add(new Ingredient("Lettuce", 2, 5));
        ingredients.add(new Ingredient("Onion", 15, 10));
        ingredients.add(new Ingredient("Garlic", 7, 5));
        ingredients.add(new Ingredient("Beef", 3, 6));
        ingredients.add(new Ingredient("Chicken", 12, 8));
        ingredients.add(new Ingredient("Flour", 25, 15));
        ingredients.add(new Ingredient("Sugar", 18, 10));
        ingredients.add(new Ingredient("Salt", 40, 20));



        // 🚚 Mock suppliers
        Supplier supplier1 = new Supplier("FreshFoods");
        supplier1.addIngredientPrice(new Ingredient("Tomato", 0, 0), 2.0);
        supplier1.addIngredientPrice(new Ingredient("Cheese", 0, 0), 5.5);
        supplier1.addIngredientPrice(new Ingredient("Garlic", 0, 0), 1.0);
        supplier1.addIngredientPrice(new Ingredient("Beef", 0, 0), 10.0);

        Supplier supplier2 = new Supplier("GreenHarvest");
        supplier2.addIngredientPrice(new Ingredient("Lettuce", 0, 0), 1.2);
        supplier2.addIngredientPrice(new Ingredient("Onion", 0, 0), 1.8);
        supplier2.addIngredientPrice(new Ingredient("Chicken", 0, 0), 6.5);

        Supplier supplier3 = new Supplier("DailyEssentials");
        supplier3.addIngredientPrice(new Ingredient("Flour", 0, 0), 0.9);
        supplier3.addIngredientPrice(new Ingredient("Sugar", 0, 0), 1.1);
        supplier3.addIngredientPrice(new Ingredient("Salt", 0, 0), 0.5);

        suppliers.add(supplier1);
        suppliers.add(supplier2);
        suppliers.add(supplier3);

        isLoggedIn = false;

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

/*        for (Person user : users) {
            if (user.getUserName().equals(name)) {
                if (user.getPass().equals(pass)) {
                    validation = true;
                    loggedInUser = user;
                    message = "User Found";
                    return;
                } else {
                    message = "Incorrect password";
                    return;
                }
            }
            }
        */

        for (chef chef : chefs) {
            if (chef.getUserName().equals(name)) {
                if (chef.getPass().equals(pass)) {
                    validation = true;
                    loggedInUser = chef;
                    message = "Chef Found";
                    return;
                } else {
                    message = "Incorrect password";
                    return;
                }
            }

        }

        for (Manager Manager : managers) {
            if (Manager.getUserName().equals(name)) {
                if (Manager.getPass().equals(pass)) {
                    validation = true;
                    loggedInUser = Manager;
                    message = "Manager Found";
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

  /*  public void addCustomerProfile(String name, String preference, String allergy) {
        CustomerProfile customer = new CustomerProfile(name, preference, allergy); // null = لم يُطلب بعد
        if (customer.isValid()) {
            customerProfiles.add(customer);
            System.out.println("✅ Customer added: " + name);
        } else {
            System.out.println("❌ Invalid customer data.");
        }
    }*/

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









    private List<String> suggestedMeals = Arrays.asList(
            "Mushroom Risotto",
            "Almond Milk Smoothie",
            "Lentil Stew",
            "Vegan Tofu Stir-Fry",
            "Grilled Chicken"
    );

    public List<String> getFilteredSuggestedMeals(CustomerProfile profile) {

        List<String> allowedMeals = new ArrayList<>();

        for (String meal : suggestedMeals) {
            // If meal doesn't mention allergy AND matches preference

            if (!meal.toLowerCase().contains(profile.getAllergy().toLowerCase()) &&
                    meal.toLowerCase().contains(profile.getDietaryPreference().toLowerCase())) {
                allowedMeals.add(meal);
            }
        }

        return allowedMeals;
    }



    ////////////////////orders////////////////////////////


    private Map<String, List<String>> pendingOrders = new HashMap<>();



    public void addToPendingOrders(String customerName, String meal) {
        pendingOrders.putIfAbsent(customerName, new ArrayList<>());
        pendingOrders.get(customerName).add(meal);

        System.out.println("⚠️ Order added to pending list. Please confirm it before submission.");
    }


    public List<String> getPendingOrders(String customerName) {
        return pendingOrders.getOrDefault(customerName, new ArrayList<>());
    }

    public void confirmOrders(String customerName) {
        List<String> confirmed = pendingOrders.get(customerName);
        if (confirmed != null && !confirmed.isEmpty()) {
            for (String meal : confirmed) {
                addMealToOrderHistory(customerName, meal); // Move to history
                //////// You can also notify or assign it to chef logic here
            }
            pendingOrders.put(customerName, new ArrayList<>()); // Clear pending
            System.out.println("✅ Orders confirmed and sent to the chef.");
        } else {
            System.out.println("⚠️ No pending orders to confirm.");
        }
    }

///////////////////////////////////history////////////////////////////
private Map<String, List<String>> orderHistory = new HashMap<>();


    public void addMealToOrderHistory(String customerName, String meal) {
        orderHistory.putIfAbsent(customerName, new ArrayList<>());
        orderHistory.get(customerName).add(meal);
    }

    public void reorderMeal(String customerName, String meal)
    {
        pendingOrders.putIfAbsent(customerName, new ArrayList<>());
        pendingOrders.get(customerName).add(meal);

        System.out.println("⚠️ '" + meal + "' has been added to your pending orders.");
        System.out.println("Please confirm your order to send it to the chef.");

    }

    public List<String> getOrdersForCustomer(String customerName) {
        return orderHistory.getOrDefault(customerName, new ArrayList<>());


    }


    private Map<String, List<String>> allOrders = new HashMap<>();

    public void addOrder(String customerName, String meal) {
        allOrders.putIfAbsent(customerName, new ArrayList<>());
        allOrders.get(customerName).add(meal);
    }



/////////////////// kitchen manager ///////////////////

    public static void assignTaskToChef(String task, String requiredExpertise) {
    chef bestChef = null;

    for (chef chef : chefs) {
        if (chef.getExpertise().equalsIgnoreCase(requiredExpertise)) {
            if (bestChef == null || chef.getTaskCount() < bestChef.getTaskCount()) {
                bestChef = chef;
            }
        }
    }

    if (bestChef != null) {
        bestChef.assignTask(task);
    } else {
        System.out.println("❌ No chef available with expertise: " + requiredExpertise);
    }
}


    public static void viewAssignedTasksForChef(String chefName) {
        for (chef chef : chefs) {
            if (chef.getUserName().equalsIgnoreCase(chefName)) {
                System.out.println("📋 Tasks for " + chef.getUserName() + ":");
                for (String task : chef.getAssignedTasks()) {
                    System.out.println(" - " + task);
                }
                return;
            }
        }
        System.out.println("❌ Chef not found.");
    }










































}
