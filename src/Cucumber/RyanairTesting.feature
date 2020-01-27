Feature: Book a flight

  Scenario Outline: Search return ticket for a specific date
    Given I make a booking from "<from>" to "<to>" on "<dateF>" "<monthF>" "<dateR>" "<monthR>" for <0> adults and <1> child
    When I pay for booking with card details "<cardNo>", "<CVV>", "<date>", "<cardholderName>", "<address>", "<city>","<zip>" and "<country>"
    Then I should get payment declined message
    Examples:
            | from | to | dateF | monthF | dateR | monthR | 0        | 1          | cardNo | CVV | date | cardholderName | address | city | country | zip   |
            |Toulouse|Malta |23       |Apr       |26       |Apr       |2           |1             |5555555555555555|456|09/21 |Talida Rosioru    |str. Victoriei|Costesti|Romania |115200   |