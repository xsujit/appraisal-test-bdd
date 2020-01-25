@RegistrationTest
Feature: Registration of users should be successful

  Scenario: User should be able to register
    Given I open the appraisal application
    And click on Register link
    When I enter my details on the registration page
      | firstName | lastName | username               | password | employeeId | location |
      | Peter     | Mason    | peter.mason@gmail.com  | password | 11564      | Bradford |
    And click on submit
    Then page should be redirected to "/login"
    Then I should be registered

