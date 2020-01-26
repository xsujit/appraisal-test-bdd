@LoginTest
Feature: Login

  Scenario Outline: Login should be successful
    Given I open the "login" page
    And I have valid "<username>" and "<password>"
    When I click on login
    Then I should be logged in
    Examples:
      | username              | password |
      | jack.bauer@mastek.com | password |