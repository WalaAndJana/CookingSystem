Feature: Customer Notifications

  Scenario: Send notification for upcoming meal
    Given a customer has an upcoming meal delivery
    When the system sends a reminder notification
    Then the customer should receive the notification