Feature: Greed Game Scoring

  Scenario: Scoring a single one
    Given I throw the following dice: 1
    When I calculate my score
    Then I should have a score of 100

  Scenario: Scoring a single five
    Given I throw the following dice: 5
    When I calculate my score
    Then I should have a score of 50

  Scenario: Scoring triple ones
    Given I throw the following dice: 1, 1, 1
    When I calculate my score
    Then I should have a score of 1000

  Scenario: Scoring triple twos
    Given I throw the following dice: 2, 2, 2
    When I calculate my score
    Then I should have a score of 200

  Scenario: Scoring triple threes
    Given I throw the following dice: 3, 3, 3
    When I calculate my score
    Then I should have a score of 300

  Scenario: Scoring triple fours
    Given I throw the following dice: 4, 4, 4
    When I calculate my score
    Then I should have a score of 400

  Scenario: Scoring triple fives
    Given I throw the following dice: 5, 5, 5
    When I calculate my score
    Then I should have a score of 500

  Scenario: Scoring triple sixes
    Given I throw the following dice: 6, 6, 6
    When I calculate my score
    Then I should have a score of 600

  Scenario: Scoring four-of-a-kind
    Given I throw the following dice: 2, 2, 2, 2
    When I calculate my score
    Then I should have a score of 200*2 = 400

  Scenario: Scoring five-of-a-kind
    Given I throw the following dice: 3, 3, 3, 3, 3
    When I calculate my score
    Then I should have a score of 300*4 = 1200

  Scenario: Scoring six-of-a-kind
    Given I throw the following dice: 4, 4, 4, 4, 4, 4
    When I calculate my score
    Then I should have a score of 400*8 = 3200

  Scenario: Scoring a straight
  Given I throw the following dice: 1, 2, 3, 4, 5, 6
  When I calculate my score
  Then I should have a score of 1200

  Scenario: Scoring three pairs
    Given I throw the following dice: 1, 1, 2, 2, 3, 3
    When I calculate my score
    Then I should have a score of 800

  Scenario: Scoring with a mix of non-scoring dice
    Given I throw the following dice: 2, 3, 4, 6, 2, 3
    When I calculate my score
    Then I should have a score of 0

  Scenario: Scoring with a mix of scoring and non-scoring dice
    Given I throw the following dice: 3, 3, 4, 6, 5, 1
    When I calculate my score
    Then I should have a score of 150

  Scenario: Scoring with a triple five with two ones
    Given I throw the following dice: 5, 5, 5, 1, 1, 2
    When I calculate my score
    Then I should have a score of 700

  Scenario: Scoring with a one and only non-scoring dice
    Given I throw the following dice: 2, 3, 4, 6, 2, 1
    When I calculate my score
    Then I should have a score of 100

  Scenario: Scoring with a five and only non-scoring dice
    Given I throw the following dice: 2, 3, 4, 6, 2, 5
    When I calculate my score
    Then I should have a score of 50

  Scenario: Scoring with two triplets
    Given I throw the following dice: 2, 2, 2, 3, 3, 3
    When I calculate my score
    Then I should have a score of 500

  Scenario: Scoring with two triplets of special numbers (1 and 5)
    Given I throw the following dice: 1, 1, 1, 5, 5, 5
    When I calculate my score
    Then I should have a score of 1500

  Scenario: Scoring with random non valid dice
    Given I throw the following dice: -1, 0, 8, 100, -16, 15
    When I calculate my score
    Then I should have an error message saying "Dice are not valid . Must be between 1 and 6 (included)"

