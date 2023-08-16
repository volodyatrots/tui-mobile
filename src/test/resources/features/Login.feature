@login
Feature: Login scenarios


  Scenario: Login with valid user name
    When user enters correct username and password values
    Then user gets directed to samples list page

  Scenario: Login with invalid user name
    When user enters incorrect username and password values
    Then user gets login error message
