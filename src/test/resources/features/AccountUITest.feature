@UITest
Feature:  Test that user can see account creation date

  @Positive @Smoke
  Scenario Outline: User can check first account activity as account creation date
    Given Account page: User navigates with <browser> to login page with username: <username> and password: <password>
    When User clicks Account info tab in inbox page
    And User clicks Recent Activity in profile page
    Then User can see account history
    And User can scroll to the bottom of activity list
    And Earliest activity matches <creationDate>

    Examples:
      | browser | username          | password   | creationDate                   |
      | chrome  | davidtestaccount1 | Password@1 | Wed, Dec 26, 2018 12:55 PM PST |
#      | firefox | davidtestaccount1 | Password@1 | Wed, Dec 26, 2018 12:55 PM PST |