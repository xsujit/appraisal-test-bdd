@RegistrationTest
Feature: Registration of users should be successful on Appraisal application

  Scenario Outline: New users should be able to register
    Given I am a new appraisal app user
      | firstName   | lastName   | username   |
      | <firstName> | <lastName> | <username> |
#    When I enter my details on the registration page
#      | firstName   | lastName   | username   | password   | employeeId   | location   |
#      | <firstName> | <lastName> | <username> | <password> | <employeeId> | <location> |
    When I register on the app
    And I login to the appraisal application
#    And click on submit
#    Then page should be redirected to "/login"
#    Then I should be registered
    Examples:
      | firstName | lastName | username               |
      | Peter     | Mason    | peter.mason@gmail.com  |
      | Jason     | Strong   | jason.strong@gmail.com |
      | Keith     | Hilton   | keith.hilton@gmail.com |

