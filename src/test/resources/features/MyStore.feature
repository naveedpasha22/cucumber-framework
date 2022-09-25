Feature: As a customer I register and purchage my orders

  Scenario: Verify registration and checkout process
  Given Test Application "http://automationpractice.com/index.php"
  When I Create an Account and complete the registration
  And I navigated to the landing screen
  And I Sign out from the landing screen
  And I Sign in to the landing screen
  Then I proceed with my order and checkout
  And I verify order details
   