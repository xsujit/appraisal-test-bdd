@LoginTest
Feature: Login

  Scenario Outline: Login should be successful
    Given I open the application and login using the following
      | <username> |
      | <password> |
#    And I have valid "<username>" and "<password>"
#    When I click on login
    Then I should be logged in
    When I click on logout
    Examples:
      | username              | password |
      | jack.bauer@mastek.com | password |
#      | james.bond@mastek.com | password |