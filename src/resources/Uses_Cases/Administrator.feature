Feature: System Administrator Functions

  Background:
    Given the system is monitoring ingredient stock levels in real-time
    And the system administrator has set the low stock threshold to 10 units
    And the system administrator has set the critical stock threshold to 5 units

  Scenario: Generate financial reports
    Given the system administrator requests financial data for "Q1 2023"
    When they generate the financial report
    Then the system should provide a report containing:
      | revenue | expenses | profit |
      | 15000.0 | 8000.0   | 7000.0 |

  Scenario: Analyze customer trends
    Given the system administrator wants to analyze customer trends
    When they run the trend analysis report
    Then they should see popular meals and ordering patterns

  Scenario: Monitor inventory alerts
    Given an ingredient "Olive Oil" is below threshold
    When the system administrator checks inventory alerts
    Then they should see an alert for "Olive Oil"