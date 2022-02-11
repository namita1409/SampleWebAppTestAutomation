Feature: Basket tests

  As a user
  I should add/edit/delete products in bag

  @bag
  Scenario: Validate adding products in the bag

    Given I am on home page "http://www.next.co.uk"
    When I search for product "T-shirt"
    And I click on search button
    Then appropriate page should be displayed with title as "T-Shirt"
    And I choose a product "Cap Sleeve T-Shirt"
    And I choose size "8"
    And I click add to bag button
    Then I should see the product " Cap Sleeve T-Shirt" in the bag
