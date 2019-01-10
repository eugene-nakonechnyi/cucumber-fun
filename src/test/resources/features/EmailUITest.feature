@UITest
Feature:  User should be able to use Yahoo mail to manage emails

  @Positive @Smoke
  Scenario Outline: User can send an email
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks compose button
    Then User can input an <address>
    And User can input a <subject>
    And User can write a <body>
    And User can click send button
    Then Email is displayed in Sent folder <body>

    Examples:
      | browser | username          | password   | address                     | subject      | body                           |
      | chrome  | davidtestaccount1 | Password@1 | davidtestaccount2@yahoo.com | Test Message | This is a test message.        |
#      | chrome  | davidtestaccount1 | Password@1 | davidtestaccount2@yahoo.com | Test Message | This is a second test message. |
      | firefox | davidtestaccount1 | Password@1 | davidtestaccount2@yahoo.com | Test Message | This is a test message.        |

  @Positive
  Scenario Outline: User can delete an email
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks compose button
    Then User can input an <address>
    And User can input a <subject>
    And User can write a <body>
    And User can click send button
    Then User can delete the email

    Examples:
      | browser | username          | password   | address                     | subject      | body                           |
      | firefox  | davidtestaccount1 | Password@1 | davidtestaccount1@yahoo.com | Test Message | This is a test message.        |

  @Positive
  Scenario Outline: User can use email toolbar to archive a message
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks compose button
    Then User can input an <address>
    And User can input a <subject>
    And User can write a <body>
    And User can click send button
    Then User can use archive on the email

    Examples:
      | browser | username          | password   | address                     | subject      | body                    |
      | chrome  | davidtestaccount1 | Password@1 | davidtestaccount1@yahoo.com | Test Message | This is a test message. |

  @Positive
  Scenario Outline: User can use email toolbar to move a message
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks compose button
    Then User can input an <address>
    And User can input a <subject>
    And User can write a <body>
    And User can click send button
    Then User can use move on the email

    Examples:
      | browser | username          | password   | address                     | subject      | body                    |
      | chrome  | davidtestaccount1 | Password@1 | davidtestaccount1@yahoo.com | Test Message | This is a test message. |

  @Positive
  Scenario Outline: User can use email toolbar to move a message
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks compose button
    Then User can input an <address>
    And User can input a <subject>
    And User can write a <body>
    And User can click send button
    Then User can use spam on the email

    Examples:
      | browser | username          | password   | address                     | subject      | body                    |
      | chrome  | davidtestaccount1 | Password@1 | davidtestaccount1@yahoo.com | Test Message | This is a test message. |


  @Positive
  Scenario Outline: User can create a new folder
    Given User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks create custom folder
    Then New can enter <folderName>
    And New folder is created
#    Then User can delete <folderName>

    Examples:
      | browser | username          | password   | folderName  |
      | chrome  | davidtestaccount1 | Password@1 | Test Folder |