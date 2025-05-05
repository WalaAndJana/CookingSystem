package org.example;

import all.CustomerProfile;
import all.Manager;
import all.MyApplication;
import all.chef;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        // Assign tasks to chefs
//        MyApplication.assignTaskToChef("Grill Chicken Breast", "grilling");
//        MyApplication.assignTaskToChef("Make Vegan Salad", "vegan");
//        MyApplication.assignTaskToChef("Bake Chocolate Cake", "baking");
//
//        // Try reassigning another grilling task (to check workload balancing)
//        MyApplication.assignTaskToChef("Grill Lamb Chops", "grilling");
//
//        // View assigned tasks for chefs
//        MyApplication.viewAssignedTasksForChef("chef1");
//        MyApplication.viewAssignedTasksForChef("chef2");
//        MyApplication.viewAssignedTasksForChef("chef3");
//
//        // Try assigning a task with no matching expertise
//        MyApplication.assignTaskToChef("Cook Sushi", "japanese");
//
//        // Try viewing a chef that doesn't exist
//        MyApplication.viewAssignedTasksForChef("chef999");
//        // Add chefs manually
//        MyApplication.chefs.add(new chef("chef1", "grilling", "chef1pass", "chef"));
//        MyApplication.chefs.add(new chef("chef2", "vegan", "chef2pass", "chef"));
//        MyApplication.chefs.add(new chef("chef3", "baking", "chef3pass", "chef"));
//
//        // Assign tasks to available chefs
//        MyApplication.assignTaskToChef("Grill steak", "grilling");      // ✅ chef1
//        MyApplication.assignTaskToChef("Vegan curry", "vegan");         // ✅ chef2
//        MyApplication.assignTaskToChef("Bake cookies", "baking");       // ✅ chef3
//        MyApplication.assignTaskToChef("Grill chicken", "grilling");    // ✅ chef1 again
//
//        // View assigned tasks
//        MyApplication.viewAssignedTasksForChef("chef1");
//        MyApplication.viewAssignedTasksForChef("chef2");
//        MyApplication.viewAssignedTasksForChef("chef3");
//


//        public void chefSelectCustomerFromList(Scanner scanner) {
//            List<CustomerProfile> profiles = getCustomerProfiles();
//
//            if (profiles.isEmpty()) {
//                System.out.println("❌ No customer profiles available.");
//                return;
//            }
//
//            System.out.println("👥 Available Customers:");
//            for (int i = 0; i < profiles.size(); i++) {
//                System.out.printf("%d. %s%n", i + 1, profiles.get(i).getName());
//            }
//
//            System.out.print("Select a customer number: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // clear newline
//
//            if (choice < 1 || choice > profiles.size()) {
//                System.out.println("❌ Invalid choice.");
//                return;
//            }
//
//            CustomerProfile selected = profiles.get(choice - 1);
//            System.out.println("👤 Profile for " + selected.getName() + ":");
//            System.out.println("   • Dietary Preference: " + selected.getDietaryPreference());
//            System.out.println("   • Allergy: " + selected.getAllergy());
//        }
//


        Manager.addIngredient("Tomato", 20, 5);
        Manager.addIngredient("Chicken", 10, 3);

        Manager.useIngredient("Tomato", 3);  // ✅ okay
        Manager.useIngredient("Tomato", 15); // ⚠️ triggers restock alert

        Manager.showInventory();

        Manager.restockIngredient("Tomato", 20);
        Manager.showInventory();

    }


}

