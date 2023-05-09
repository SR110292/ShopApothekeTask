Feature:A customer is able to successfully log in with valid credentials.

  Scenario Outline: Verify a customer is able to successfully login using valid credentials
    Given CreateLoginPayload with "<username>" and "<password>"
    When User calls "LoginAPI" with POST request for "<deviceType>" and "<tenant>"
    Then The status code in the response is 201
    And "<tokenType>" is displayed as "tokenType" in the response body
    Examples:
      | username                | password         | deviceType | tenant | tokenType |
      | shop-user@redteclab.com | aA1!bB2@cC3#dD4$ | browser    | at     | bearer    |

  Scenario Outline: Verify a customer is not able to login with invalid credentials
    Given CreateLoginPayload with "<username>" and "<password>"
    When User calls "LoginAPI" with POST request for "<deviceType>" and "<tenant>"
    Then The status code in the response is 400
    And "<statusCode>" is displayed as "statusCode" in the response body
    And "<error>" is displayed as "error" in the response body
    And "<message>" is displayed as "message" in the response body
    Examples:
      | username                | password         | deviceType | tenant | statusCode | error       | message                                                  |
      | shop-user@redteclab.com | aA1!bB2@cC3#dD4$ | iosApp     | fr     | 400        | Bad Request | customer-authentication.error.wrong.username.or.password |
      | shop-user@redteclab.com | aA1!bB2@cC3#dD4$ | browser    | ch     | 400        | Bad Request | customer-data-service.error.bad_request                  |
      | shop-user@redteclab.com | aA1!bB2@cC3#dD4$ | androidApp | it     | 400        | Bad Request | customer-data-service.error.bad_request                  |