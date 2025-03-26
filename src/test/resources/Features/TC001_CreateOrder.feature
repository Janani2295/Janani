Feature: Create Order in FE and verify in BE

  @Login
  Scenario Outline: Place Order through Web application
    Given User is on the OMR Branch hotel page
    When User should login "<userName>","<password>"
    Then User should verify success message after login "Welcome Janani"
    When User enter search keyword "Nuts" for product
    And User select the product name contains "Happilo 100% Natural Premium California Almonds | Premium Badam Giri" from the product list
    And User added the product to cart
    And User add new address "<first_name>","<last_name>","<mobile>","<apartment>","<state>","<city>","<country>","<zipcode>","<address>",and "<address_type>"
    And User enter payment details, procced with card type "<cardType>"
      | Select card | CardNo           | CardName  | Month | Year | CVV |
      | Visa        | 5555555555552222 | Your name | March | 2025 | 123 |
      | Mastercard  | 5555555555554444 | Your name | March | 2025 | 123 |
      | Amex        | 5555555555550000 | Your name | March | 2025 | 123 |
      | Discover    | 5555555555556666 | Your name | March | 2025 | 123 |
    Then User should verify order placed success message contains "Order is Confirmed" and save Order number

    Examples: 
      | userName                   | password    | first_name | last_name | mobile     | apartment | state          | city     | country | zipcode | address | address_type | cardType   |
      | jananivinoth1709@gmail.com | Janani@1995 | Janani     | Vinoth    | 9803456728 | apartment | Andhra Pradesh | Tirupati | India   |  614908 | Chennai | Home       | debit_card |

  Scenario: Get User logtoken from login endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the status code is 200
    And User should verify the login response body firstName present as "Janani" and get the logtoken saved

  Scenario: Verify User able to get all the Order details
    Given User add header and bearer authorization for accessing get all the Order endpoints
    When User send "GET" request for get all order endpoint
    Then User should verify the status code is 200
    And User should verify the get all order response message matches "OK" and save the order id

  Scenario: Verify User able to get the specific Order details
    Given User add header and bearer authorization for accessing get all the Order endpoints
    When User pass order id as query param
    And User send "GET" request for get specific order endpoint
    Then User should verify the status code is 200
    And User should verify the get all order response message matches "OK" and verify the product name "Happilo 100% Natural Premium California Almonds | Premium Badam Giri"
