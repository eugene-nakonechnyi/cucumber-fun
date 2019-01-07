@UITest
Feature:  Test Actions class to test complex user gestures: drag and drop, context click, and clicking last element in a list

  @Positive @Smoke
  Scenario Outline: Actions can be used to drag and drop
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User drags an email to archive at inbox page
    And User can click undo button at inbox page

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount1 | Password@1 |

  @Positive
  Scenario Outline: Actions can be used to context click
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    Then User can open an an email at inbox page

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount1 | Password@1 |

  @Positive
  Scenario Outline: Actions can be used to select last email
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    Then User can open last email at inbox page

    Examples:
      | browser | username          | password   |
      | chrome  | davidtestaccount1 | Password@1 |
#      | firefox | davidtestaccount1 | Password@1 |