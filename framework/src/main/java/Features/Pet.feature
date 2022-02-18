@pet
Feature: Upload functionality test

  Scenario: upload image pet
    Given User sends the request to upload an image
    Then  User Validate if status is 200

  Scenario: upload image pet
    Given User sends the wrong request to upload an image
    Then  User Validate if status is 404

