@LoginTest
Feature: Login

  Scenario Outline: Login should be successful
    Given I am an appraisal app user
      | <username> |
      | <password> |
    And I login to the appraisal application
#    And I have valid "<username>" and "<password>"
#    When I click on login
    When I click on Team
    And I click on view
#    Then I should be logged in
#    When I click on logout
    Examples:
      | username              | password |
      | jack.bauer@mastek.com | password |
#      | james.bond@mastek.com | password |