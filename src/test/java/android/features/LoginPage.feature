@LoginPage
Feature: LoginScreen Feature

  @InvalidLogin
  Scenario Outline: Login with invalid e-mail
    Given Click on continue with e-mail
    When E mail entered <email>
    Then Check invalid error message
    Examples:
      | email          |
      | denemetest@d.c |
      | t@deneme.test  |

  @SuccessLogin
  Scenario: Login with success e-mail
    Given Click on continue with e-mail
    When E mail "denemepoc123@gmail.com" entered and google step pass
    Then Check successful login

  @LookingCoffeeReading
  Scenario: Coffee Reading
    Given Login with "denemepoc123@gmail.com" via continue with e-mail
    When Looking coffee reading
    Then Coffee reading request verified

