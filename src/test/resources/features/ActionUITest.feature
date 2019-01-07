@UITest
Feature:  Test Actions class to test complex user gestures: drag and drop, context click, and clicking last element in a list

  @Positive @Smoke
  Scenario Outline: Actions can be used to drag and drop
    Given User navigates with <browser> to login page
    And User enters username: <username>
    When User clicks Next
    Then Password screen should be displayed
    And User enters password: <password>
    When User clicks sign in button
    When User drags an email to archive
#    And User can click undo button

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount1 | Password@1 |

  @Positive
  Scenario Outline: Actions can be used to context click
    Given User navigates with <browser> to login page
    And User enters username: <username>
    When User clicks Next
    Then Password screen should be displayed
    And User enters password: <password>
    When User clicks sign in button
    And User can open an an email

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount1 | Password@1 |

  @Positive
  Scenario Outline: Actions can be used to select last email
    Given User navigates with <browser> to login page
    And User enters username: <username>
    When User clicks Next
    Then Password screen should be displayed
    And User enters password: <password>
    When User clicks sign in button
    And User can open last email

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount1 | Password@1 |