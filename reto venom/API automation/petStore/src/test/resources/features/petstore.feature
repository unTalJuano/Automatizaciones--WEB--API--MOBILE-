Feature: Swagger Pet Store API

  Scenario: Add a new pet to the store
    Given the API endpoint is "/pet"
    When I send a POST request with valid pet details
    Then the response status should be 200
    And the pet should be added successfully

  Scenario: Get pet details by ID
    Given the API endpoint is "/pet/{petId}"
    When I send a GET request with pet ID "1"
    Then the response status should be 200
    And the pet details should match the provided ID