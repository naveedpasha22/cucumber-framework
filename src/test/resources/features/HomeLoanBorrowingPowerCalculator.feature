Feature: As a loan borrowing customer I need to validate home page

  Scenario: Verify home loan borrowing power calculator
    Given I am on the home page URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When I fill Your details
    And I fill your earnings
    And I fill Your expenses
    #1 Borrowing estimate
    Then verify the borrowing estimate
    #2 Clicking the ‘start over’ button clears the form.
    And clear the form on clicking start over button
    #3 Entering only $1 for Living expenses, and leaving all other fields as zero and verify error message
    And verify error message up on filling only Living expenses
    