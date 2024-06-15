Feature: Login Functionality two


  Scenario Outline: User logs in with valid credentials
    Given the user is on the main page of the website and get the Title of the page
    Then The user will click on Account
    When The user will write invalid username "<username>" and password "<password>"
    Then The user will click sign button
    When the browser is gonna close

    Examples:
      | username | password  |
      | user1    | password1 |
      | islam    | ibrahim   |



