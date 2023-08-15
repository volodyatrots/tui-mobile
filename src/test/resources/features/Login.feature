@login
Feature: Login scenarios


  Scenario: Login with valid user name
    When I login
    Then samples list should appear

  Scenario: Login with invalid user name
    When I login with invalid credentials
    Then error message should appear
