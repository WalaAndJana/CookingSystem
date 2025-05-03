package org.example;

import all.CustomerProfile;
import all.MyApplication;

public class Main {
    public static void main(String[] args) {

        MyApplication app = new MyApplication();

        // إضافة زبائن يدويًا
        app.addCustomerProfile("Alice", "Vegetarian", "Nuts");
        app.addCustomerProfile("Mark", "Vegan", "Dairy");
        app.addCustomerProfile("Sara", null, "Gluten"); // هاد غير صالح مثلاً

        // طباعة كل الزبائن المضافين
        System.out.println("\n--- All Customers ---");
        for (CustomerProfile c : app.getCustomerProfiles()) {
            System.out.println("👤 " + c.getName() +
                    " | Preference: " + c.getDietaryPreference() +
                    " | Allergy: " + c.getAllergy());
        }
    }




}

