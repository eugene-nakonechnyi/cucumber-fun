@UITest
  Feature:  User can login to Yahoo mailbox

  @Positive
  Scenario Outline: Login to yahoo mail test account
    Given User navigates with <browser> to login page
    And User enters username: <username>
    When User clicks Next
    Then Password screen should be displayed
    And User enters password: <password>
    When User clicks sign in button
    Then Mailbox screen should be displayed

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | chrome  | davidtestaccount2 | Password@1 |
      | firefox | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount2 | Password@1 |


@UITest
  Feature:  Wait limits work while loading different pages

  @Positive @Smoke
  Scenario Outline: Navigate to new folder, tab, and page from Inbox
    Given User navigates with <browser> to login page
    And User enters username: <username>
    When User clicks Next
    Then Password screen should be displayed
    And User enters password: <password>
    When User clicks sign in button
    When User clicks Unread from login page
    And User clicks top right menu from login page
    Then User can click Yahoo link from login page
    And New tab is displayed from login page

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | chrome  | davidtestaccount2 | Password@1 |
      | firefox | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount2 | Password@1 |


