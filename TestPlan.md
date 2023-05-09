# SHOP APOTHEKE API Test Plan
1. Successful login of a customer using valid credentials with default parameters
2. Successful login of a customer using valid credentials with different values in cacheable variable and verify each response
3. Successful login of a customer using valid credentials with different values in the tenant parameter  and verify each response
4. Successful login of a customer using valid credentials with different values in the "Sae-Device-Type" header  and verify each response
5. Unsuccessful login of a customer using invalid username and verify the response
6. Unsuccessful login of a customer using invalid password and verify the response
7. Unsuccessful login of a customer when no username is sent in the request payload
8. Unsuccessful login of a customer when no password is sent in the request payload
9. Unsuccessful login of a customer due to Gateway timeout and verify the response

### Example Test Case
Verify the successful login of a customer with valid credentials with default parameters and also verify the response

    1. Set the URL as "https://api.sa-tech.de/auth/v2/{tenant}/login"

    2. Add the path parameter "tenant" as "ch"

    3. Create a login payload with valid username and password as below
            {
                username: shop-user@redteclab.com
                password: aA1!bB2@cC3#dD4$
            }

    4. Send the above request as HTTP Post request

    5. Verify the response status code is "201"

    6. Verify the response description is "SuccessResponse"

    7. Verify the response body has the key "tokenType" with the value as "bearer"

    8. Verify the response body has the key "token" with some random value


### Few observations
1. Unable to successfully log in with the example credentials
2. "invalidParams" property is not displayed in the response for the "BadRequestAuthentication"
3. The error description is different for different tenant parameters. Need more clarification on the same


