Feature: Customer


  Scenario Outline: tore dietary preferences and allergies
    Given a customer wants to input their dietary preferences
    And the preference details:
      | Customer Name | Dietary Preference | Allergy  |
      | <Customer>   | <Preference>       | <Allergy> |
    When they save their profile
    Then the system should store their preferences
    And ensure meals do not contain restricted ingredients

    Examples:
      | Customer | Preference  | Allergy  |
      | Alice    | Vegetarian  | Nuts     |
      | Mark     | Vegan       | Dairy    |


  Scenario Outline: Track past orders and meal plans
    Given a customer wants to view their past orders
    And  order history details:
      | Customer Name | Last Ordered Meal      |
      | <Customer>    | <LastMeal>             |
    When they access their order history
    Then the system should display their past meal orders

    Examples:
      | Customer | LastMeal               |
      | Sarah    | Grilled Chicken Salad  |
      | Tom      | Gluten-Free Pasta      |







  Scenario Outline: Create custom meal requests
    Given a customer wants to customize their meal
    And the customization details:
      | Customer Name | Selected Ingredients    |
      | <Customer>    | <Ingredients>           |
    When they place a custom order
    Then the system should validate the ingredient selection
    And ensure it meets dietary restrictions

    Examples:
      | Customer | Ingredients              |
      | Emily    | Quinoa, Avocado, Spinach |
      | Jake     | Tofu, Rice, Broccoli     |



  Scenario Outline: Suggest ingredient substitutions
    Given a customer selects an unavailable ingredient
    And substitution details:
      | Customer Name | Original Ingredient | Suggested Substitute |
      | <Customer>    | <Original>          | <Substitute>         |
    When they receive the suggested substitution
    Then they should approve or reject the change

    Examples:
      | Customer | Original    | Substitute  |
      | Anna     | Almond Milk | Oat Milk    |
      | Bob      | Sugar       | Stevia      |