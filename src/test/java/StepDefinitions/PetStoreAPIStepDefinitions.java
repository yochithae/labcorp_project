package StepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class PetStoreAPIStepDefinitions {
    private String baseUrl = "https://petstore.swagger.io/v2";
    private Response response;

    @Given("I have a new user data")
    public void iHaveANewUserData() {

    }

    @When("I send a POST request to create the user")
    public void iSendAPOSTRequestToCreateTheUser() {
        String userData = "[{\"id\": 43433,\"username\": \"323243431qw\",\"firstName\": \"RRRR\",\"lastName\": \"LLL\",\"email\": \"we@gmail.com\",\"password\": \"23dwewe\",\"phone\": \"2324433\",\"userStatus\": 0}]";
        response = given().log().all().contentType("application/json").body(userData)
                .log().all().post(baseUrl + "/user/createWithArray");
        System.out.println("Response: "+response.prettyPrint());
    }

    @Then("the user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        System.out.println(statusCode);
    }

    @Given("the user is created successfully")
    public void theUserIsCreatedSuccessfully() {
        iSendAPOSTRequestToCreateTheUser();
        theUserShouldBeCreatedSuccessfully();
    }

    @When("I send a GET request to retrieve the user details")
    public void iSendAGETRequestToRetrieveTheUserDetails() {
        response = given().log().all().get(baseUrl + "/user/323243431qw").then().log().all().extract().response();
        System.out.println(response);
    }

    @Then("the user details should be returned")
    public void theUserDetailsShouldBeReturned() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(200, statusCode);
        
    }
}
