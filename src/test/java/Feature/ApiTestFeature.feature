Feature: Testing Pet Store API

Scenario: Post a new user
  Given I have a new user data
  When I send a POST request to create the user
  Then the user should be created successfully

Scenario: Retrieve user details
  Given the user is created successfully
  When I send a GET request to retrieve the user details
  Then the user details should be returned