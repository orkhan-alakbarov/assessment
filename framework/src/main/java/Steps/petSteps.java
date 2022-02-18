package Steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.CommonMethods;
import static org.junit.Assert.assertEquals;

public class petSteps extends CommonMethods {

    String url = "petURL";
    String metaData = "good boy";
    String filePath = "src/main/resources/test-data/dog.jpg";
    String wrongUrl= "wrongURL";
    Response testObject;

    @Given("User sends the request to upload an image")
    public void user_sends_the_request_to_upload_an_image() {
        testObject = submitGetRequest(url,  metaData, filePath);
    }
    @Given("User sends the wrong request to upload an image")
    public void user_sends_the_wrong_request_to_upload_an_image() {
        testObject = submitGetRequest(wrongUrl,  metaData, filePath);
    }

    @Then("User Validate if status is {int}")
    public void validate_if_status_is(int statusCode) {
        int actualStatusCode = testObject.getStatusCode();
        assertEquals(actualStatusCode, statusCode);
    }

}
