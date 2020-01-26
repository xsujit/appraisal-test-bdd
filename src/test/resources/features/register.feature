@RegistrationTest
Feature: Registration of users should be successful on Appraisal application

  Scenario Outline: New users should be able to register
    Given I open the "register" page
    When I enter my details on the registration page
      | firstName   | lastName   | username   | password   | employeeId   | location   |
      | <firstName> | <lastName> | <username> | <password> | <employeeId> | <location> |
    And click on submit
    Then page should be redirected to "/login"
    Then I should be registered
    Examples:
      | firstName | lastName | username               | password | employeeId | location |
      | Peter     | Mason    | peter.mason@gmail.com  | password | 11564      | Bradford |
      | Jason     | Strong   | jason.strong@gmail.com | password | 11565      | Bradford |
      | Keith     | Hilton   | keith.hilton@gmail.com | password | 11566      | Bradford |

