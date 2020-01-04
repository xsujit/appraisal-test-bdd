@RegistrationTest
Feature: Registration

  Scenario: User should be able to register
    Given I open the appraisal application
    And click on Register link
    When I enter my details on the registration page
      | firstName  | Peter                 |
      | lastName   | Mason                 |
      | username   | peter.mason@gmail.com |
      | password   | password              |
      | employeeId | 11564                 |
      | location   | Glasgow               |
    And click on submit
    Then I should be registered

