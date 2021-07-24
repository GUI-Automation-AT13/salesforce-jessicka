Feature: Create Product

  Scenario: Create a product with just required fields
    Given I login to salesforce as an admin user
    And I navigate to Products page
    When I create a new Product with fields
      | productName | product to test |
    Then A successful message is displayed
    And All product fields matches
    When I return to Products page and check the products
    Then The product exists

  Scenario: Create a product with all fields
    Given I login to salesforce as an admin user
    And I navigate to Products page
    When I create a new Product with fields
      | productName           | product to test            |
      | productCode           | product code               |
      | productFamilyOption   | None                       |
      | productDescription    | Product description        |
    Then A successful message is displayed
    And All product fields matches
    When I return to Products page and check the products
    Then The product exists