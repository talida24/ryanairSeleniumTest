Feature: Book a flight

  Scenario Outline: Search return ticket for a specific date
    Given I make a booking from "<arg0>" to "<arg1>" on <arg2>/<arg3>/<arg4> for <arg5> adults and <arg6> child
    When I pay for booking with card details "<arg7>", "<arg8>" and "<arg9>"
    Then I should get payment declined message
    Examples:
      | TLS | MLT | arg2 | arg3 | arg4 | arg5 | arg6 | arg7 | arg8 | arg9 |




#    Given Open https://www.ryanair.com/ie/en
#    Then Do login
#    Then Do flight search
#    Then  Select the flights with the value package
#    Then Add the credentials for the passenger 'Ms. Talida Rosioru'
#    Then Select random seats for both flights
#    Then Select included bags
#    Then Don't add any extras
#    Then Go to basket
#    Then Enter phone number
#    Then Select no insurance
#    Then Add the card information for payment
#    Then Select the currency of the payment
#    Then Accept the terms and conditions
#    Then Get error message