@login
Feature: Login scenarios


  Scenario: Login with valid user name
    When I login
    Then samples list should appear


