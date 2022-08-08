
@Gui
Feature: Google Search
  Scenario: search for edgewords
    Given   I am on the Google homepage
    When  I search for "Edgewords"
    Then  "Edgewords" appears in the results
@Ignore
    Scenario Outline: Data Drive search
      Given I am on the Google homepage
      When  I search for "<search word>"
      Then "<search word>" appears in the results
      Examples:
      |search word|
      |Edgewords  |
      |BBC        |

      Scenario: Verify Edgewords results
        Given I am on Google
        When  I search for "Edgewords"
        Then  I see in the results
        |title                                                   |url                                 |
        |Edgewords Training - Automated Software Testing Training|https://www.edgewordstraining.co.uk|
        |Edgewords - Twitter                                     |https://twitter.com › edgewords     |
