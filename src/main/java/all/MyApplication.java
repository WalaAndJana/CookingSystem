package all;

import java.util.*;

public class MyApplication {

    ///////////////log in/////////////////////////////
    //private final List<Person> users;
    public static List<chef> chefs = new ArrayList<>(); // array of ches
    public static List<Manager> managers = new ArrayList<>(); // array of managers
    public static List<Ingredient> ingredients = new ArrayList<>(); // array of ingredients
    public static List<Supplier> suppliers = new ArrayList<>();
    private List<CustomerProfile> customers = new ArrayList<>();// array of suppliers
    private List<order> pendingOrders = new ArrayList<>();
    private List<order> orderHistory = new ArrayList<>();
    private List<order> allOrders = new ArrayList<>();


    private String message;
    private boolean validation;
    private boolean Customerlogged;
    private Person loggedInUser;
    private boolean isLoggedIn;

    public MyApplication() {
       // users = new ArrayList<>();
        // mock users

        CustomerProfile alice = new CustomerProfile("Alice", "Vegetarian", "Nuts");
        CustomerProfile mark = new CustomerProfile("Mark", "Vegan", "Dairy");
        CustomerProfile emily = new CustomerProfile("Emily", "Vegetarian", "None");
        CustomerProfile tom = new CustomerProfile("Tom", "Low Carb", "Gluten");
        CustomerProfile jake = new CustomerProfile("Jake", "High Protein", "Eggs");



            customers.add(alice);
            customers.add(mark);
            customers.add(emily);
            customers.add(tom);
            customers.add(jake);

//        users.add(new Person("wala", "wala123", "customer"));
//        users.add(new Person("chef1", "chefpass", "chef"));
//        users.add(new Person("user88", "abc123", "kitchenManager"));


        chefs.add(new chef("chef1", "grilling", "chef1pass", "chef"));
        chefs.add(new chef("chef2", "vegan", "chef2pass", "chef"));
        chefs.add(new chef("chef3", "baking", "chef3pass", "chef"));

        managers.add(new Manager("manager1", "manager1pass", "manager"));
        managers.add(new Manager("manager2", "manager2pass", "manager"));
        managers.add(new Manager("manager3", "manager3pass", "manager"));

        // 🥦 Mock ingredients
        Ingredient tomato = new Ingredient("Tomato", 20, 10, new Ingredient("Red Pepper", 10, 5, null));
        Ingredient cheese = new Ingredient("Cheese", 5, 8, new Ingredient("Vegan Cheese", 10, 5, null));
        Ingredient lettuce = new Ingredient("Lettuce", 2, 5, new Ingredient("Spinach", 10, 5, null));
        Ingredient onion = new Ingredient("Onion", 15, 10, new Ingredient("Leek", 7, 4, null));
        Ingredient garlic = new Ingredient("Garlic", 7, 5, null);
        Ingredient beef = new Ingredient("Beef", 3, 6, new Ingredient("Tofu", 15, 5, null));
        Ingredient chicken = new Ingredient("Chicken", 12, 8, new Ingredient("Soy Chunks", 10, 5, null));
        Ingredient flour = new Ingredient("Flour", 25, 15, new Ingredient("Oat Flour", 10, 5, null));
        Ingredient sugar = new Ingredient("Sugar", 18, 10, new Ingredient("Stevia", 8, 3, null));
        Ingredient salt = new Ingredient("Salt", 40, 20, null);


        // 🚚 Mock suppliers
        Supplier supplier1 = new Supplier("FreshFoods");
        supplier1.addIngredientPrice(tomato, 2.0);
        supplier1.addIngredientPrice(cheese, 5.5);
        supplier1.addIngredientPrice(garlic, 1.0);
        supplier1.addIngredientPrice(beef, 10.0);

        Supplier supplier2 = new Supplier("GreenHarvest");
        supplier2.addIngredientPrice(lettuce, 1.2);
        supplier2.addIngredientPrice(onion, 1.8);
        supplier2.addIngredientPrice(chicken,6.5);

        Supplier supplier3 = new Supplier("DailyEssentials");
        supplier3.addIngredientPrice(flour,0.9);
        supplier3.addIngredientPrice(sugar, 1.1);
        supplier3.addIngredientPrice(salt, 0.5);

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
//        for (Person user : users) {
//            if (user.getUserName().equalsIgnoreCase(name)) {
//                loggedInUser = user;
//                validation = true;
//                return;
//            }
//        }
//        loggedInUser = null;
//        validation = false;
    }




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
        return customers;
    }

    public void addCustomer(CustomerProfile c) {
        if (c != null && c.isValid()) {
            customers.add(c);
            System.out.println("✅ Customer added: " + c.getName());
        } else {
            System.out.println("❌ Invalid customer object.");
        }
    }


    public CustomerProfile getProfileByName(String name) {
        for (CustomerProfile profile : customers) {
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


   // private Map<String, List<String>> pendingOrders = new HashMap<>();


    public void addToPendingOrders( CustomerProfile b, meal m) {
        pendingOrders.add(new order(b, m));
        System.out.println("⚠️ Order added to pending list. Please confirm it before submission.");
    }


    public List<order> getPendingOrdersForCustomer(CustomerProfile customer) {
        return pendingOrders.stream()
                .filter(order -> order.getCustomer().equals(customer))
                .toList();
    }

    public void confirmOrders(CustomerProfile customer) {
        List<order> toConfirm = new ArrayList<>();

        for (order order : pendingOrders) {
            if (order.getCustomer().equals(customer)) {
                orderHistory.add(order);       // ✅ Move to history
                toConfirm.add(order);          // 📌 Mark for removal
            }
        }

        if (!toConfirm.isEmpty()) {
            pendingOrders.removeAll(toConfirm);  // 🧹 Clean up
            System.out.println("✅ Orders confirmed and sent to the chef.");
        } else {
            System.out.println("⚠️ No pending orders to confirm.");
        }
    }


    ///////////////////////////////////history////////////////////////////
//    private Map<String, List<String>> orderHistory = new HashMap<>();


    public void addMealToOrderHistory(String customerName, String meal) {
        orderHistory.putIfAbsent(customerName, new ArrayList<>());
        orderHistory.get(customerName).add(meal);
    }

    public void reorderMeal(String customerName, String meal) {
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


/////////////////// kitchen manager ////////////////////

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

    ////////////////////////////////////////////////////////////////////////////
    private Set<String> unavailableIngredients = Set.of("Peanuts", "Shellfish", "Bacon");



//    public boolean validateCustomMeal(String selectedIngredients, CustomerProfile profile) {
//
//        String[] selected = ingredients.Split(",\\s*");
//        for (String ing : selected) {
//            // 1. Check allergy
//            if (profile.getAllergy().equalsIgnoreCase(ing)) {
//                System.out.println("❌ Ingredient conflicts with allergy: " + ing);
//                return false;
//            }
//            // 2. Check stock
//            if (unavailableIngredients.contains(ing)) {
//           System.out.println("⚠️ Ingredient unavailable: " + ing);
//                return false;
//            }
//        }
//        return true;
//
//
//    }





}