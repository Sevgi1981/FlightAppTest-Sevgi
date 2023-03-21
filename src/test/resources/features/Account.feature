Feature: SignUp and Login


    @smoke
  Scenario: SignUp
    Given User navigates to website and verify title as "React App"
    When User verify Home Page header title as "Search Flight"
    Then User clicks signup button and verifies signup page header as "Sign Up"
    And User fill up signup form
    Then User clicks signup button
    And User verify success message as "User Created"

    @smoke
  Scenario: Login with invalid credentials
    Given User navigates to website and verify title as "React App"
    When User verify Home Page header title as "Search Flight"
    Then User clicks signup button and verifies signup page header as "Sign Up"
    And User fill up signup form
    Then User clicks signup button
    And User verify success message as "User Created"
    Then click login button
    And Enter email and password
    Then click login for provided credentials
    And verify username on header

    @smoke
  Scenario: Verify SignUp in Database
    Given User navigates to website and verify title as "React App"
    When User verify Home Page header title as "Search Flight"
    Then User clicks signup button and verifies signup page header as "Sign Up"
    And User fill up signup form
    Then User clicks signup button
    And User verify success message as "User Created"
    Then Verify user is created in Database

    @smoke1
    Scenario: SignUP with API
      Given User add request Payload
      When User send request
      Then User verifies status code is 201

    @smoke3
  Scenario: SignUP with API and login with UI
    Given User add request Payload
    When User send request
    Then User verifies status code is 201
    Then User Login with UI by given credentials from API
