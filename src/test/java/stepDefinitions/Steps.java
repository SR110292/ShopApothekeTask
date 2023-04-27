package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.PayloadBuilder;
import resources.Utils;
import resources.enums.APIResources;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Steps extends Utils {
    public String payload;
    private Response response;

    @Given("CreateLoginPayload with {string} and {string}")
    public void createLoginPayloadWithAnd(String username, String password) {
        PayloadBuilder payloadBuilder = new PayloadBuilder();
        payload = payloadBuilder.createUserPayload(username, password);
    }

    @When("User calls {string} with POST request for {string} and {string}")
    public void userCallsWithPOSTRequestForAnd(String resource
            , String deviceType, String tenant) throws IOException {
        APIResources resourceAPI = APIResources.valueOf(resource);
        response = given()
                .spec(requestSpecification(deviceType, tenant))
                .body(payload)
                .post(resourceAPI.getResource());
    }

    @Then("The status code in the response is {int}")
    public void theStatusCodeInTheResponseIs(int expectedStatusCode) {
        int actualStatusCode = response.then()
                .log()
                .all()
                .extract()
                .response()
                .getStatusCode();
        assertEquals(expectedStatusCode, actualStatusCode);
    }

    @And("{string} is displayed as {string} in the response body")
    public void isDisplayedAsInTheResponseBody(String expectedValue, String key) {
        String responseString = response.asString();
        JsonPath jp = new JsonPath(responseString);
        String actualValue = jp.getString(key);
        assertEquals(expectedValue, actualValue);
    }


}
