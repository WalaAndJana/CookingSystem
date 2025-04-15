package ChefPackage;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class ChefNotification_Test {

//    private ChefNotification chefNotification;
//
//    public ChefNotification_Test(){
//        chefNotification = new ChefNotification();
//    }
//    @BeforeEach
//    public void setUp() {
//       // chefNotification = new ChefNotification();
//    }
//
//    // ===== Test 1: Notification Sent When Schedule Updates =====
//    @Test
//    public void testChefReceivesNotificationForScheduleUpdate() {
//        chefNotification.chefHasUpcomingMealPreparations();
//
//        // Corrected DataTable structure (List of Lists)
//        DataTable dataTable = DataTable.create(Arrays.asList(
//                Arrays.asList("Chef Name", "Task", "Notification Sent"),
//                Arrays.asList("John Doe", "Lunch Service", "Yes")
//        ));
//        chefNotification.setNotificationDetails(dataTable);
//            Assert.assertEquals("Notification should be sent", "Yes", chefNotification.notificationStatus);
//
//        chefNotification.scheduleUpdates();
//        chefNotification.verifyNotificationSent();
//    }

    // ===== Test 2: No Notification When Schedule Doesn't Change =====
//@Test
/*    public void testNoNotificationIfNotSent() {
        chefNotification.chefHasUpcomingMealPreparations();

        DataTable dataTable = DataTable.create(Arrays.asList(
                Arrays.asList("Chef Name", "Task", "Notification Sent"),
                Arrays.asList("Jane Doe", "Dinner Prep", "No")
        ));
        chefNotification.setNotificationDetails(dataTable);

        chefNotification.scheduleUpdates();

        Assertions.assertThrows(AssertionError.class, chefNotification::verifyNotificationSent,
                "Notification should not be sent when expected value is 'No'.");
    }*/

    // ===== Test 3: Alert Sent for Ingredient Substitution =====
//    @Test
/*    public void testChefReceivesAlertForIngredientSubstitution() {
        chefNotification.chefIsPreparingMeal();

        DataTable dataTable = DataTable.create(Arrays.asList(
                Arrays.asList("Chef Name", "Meal", "Substituted Ingredient", "Alert Received"),
                Arrays.asList("John Doe", "Pasta", "Soy Milk", "Yes")
        ));
        chefNotification.setAlertDetails(dataTable);

        chefNotification.applyIngredientSubstitution();
        chefNotification.verifyAlertSent();
    }*/

    // ===== Test 4: No Alert When No Ingredient is Substituted =====
  //  @Test
//    public void testNoAlertIfNoSubstitution() {
//        chefNotification.chefIsPreparingMeal();
//
//        DataTable dataTable = DataTable.create(Arrays.asList(
//                Arrays.asList("Chef Name", "Meal", "Substituted Ingredient", "Alert Received"),
//                Arrays.asList("Alice", "Salad", "None", "No")
//        ));
//        chefNotification.setAlertDetails(dataTable);
//
//        chefNotification.applyIngredientSubstitution();
//
//        Assertions.assertThrows(AssertionError.class, chefNotification::verifyAlertSent,
//                "Alert should not be sent when substitution is 'None'.");
//    }
}
