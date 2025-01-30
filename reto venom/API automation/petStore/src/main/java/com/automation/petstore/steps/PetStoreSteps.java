package com.automation.petstore.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import java.util.ResourceBundle;

import static org.hamcrest.Matchers.equalTo;

public class PetStoreSteps {

    private String endpoint;
    private Response response;
    private RequestSpecification request;
    private static final ResourceBundle config = ResourceBundle.getBundle("config");

    @Given("the API endpoint is {string}")
    public void setApiEndpoint(String endpointKey) {
        this.endpoint = config.getString(endpointKey);
        RestAssured.baseURI = config.getString("baseURI");
    }

    @When("I send a POST request with valid pet details")
    public void sendPostRequestWithPetDetails() {
        String requestBody = config.getString("addPetBody");
        request = SerenityRest.given().header("Content-Type", "application/json").body(requestBody);
        response = request.post(endpoint);
    }

    @Then("the response status should be {int}")
    public void verifyResponseStatus(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the pet should be added successfully")
    public void verifyPetAddedSuccessfully() {
        response.then().body("name", equalTo(config.getString("expectedPetName")));
    }

    @When("I send a GET request with pet ID {string}")
    public void sendGetRequestWithPetId(String petId) {
        response = SerenityRest.given().get(endpoint.replace("{petId}", petId));
    }

    @Then("the pet details should match the provided ID")
    public void verifyPetDetailsMatch() {
        response.then().body("id", equalTo(Integer.parseInt(config.getString("expectedPetId"))));
    }

}
