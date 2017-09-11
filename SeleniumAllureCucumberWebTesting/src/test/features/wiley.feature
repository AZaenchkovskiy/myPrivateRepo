#language: en
Feature: Wiley website testing

  Scenario: Home page testing
    Given open the Wiley "Home page"
    Then following item is displayed in top navigation menu:
      | link |
      | Home |
      | Subjects |
      | About Wiley |
      | Contact Us |
      | Help |
    And 9 items are displayed under Resources sub-header:
      | Students |
      | Authors |
      | Instructors |
      | Librarians |
      | Societies |
      | Conferences |
      | Booksellers |
      | Corporations |
      | Institutions |
    When click on "Students" item
    Then "http://eu.wiley.com/WileyCDA/Section/id-404702.html" url is opened
    And "Students" header is displayed

  Scenario: Students page testing
    Given open the Wiley "Students" page
    Then 7 items are displayed in Resources For menu:
      | Authors |
      | Librarians |
      | Booksellers |
      | Instructors |
      | Students |
      | Societies |
      | Corporate Partners |
    And "Students" item is displayed
    And "Students" item has different style
    And "Students" item is clickable
    Then click at "Home" link at the top navigation menu

  Scenario: Home page updates testing
    Given open the Wiley "Home" page
    Then find “Sign up to receive Wiley updates” line and click arrow button
    Then check that alert appeared with text "Please enter email address"
    Then enter invalid email and click arrow button
    Then check that alert appeared with text "Invalid email address."

  Scenario: Search engine testing
    Given open the Wiley "Home" page
    Then enter "for dummies" to the search input field and pres search icon
    Then check that list of items appeared
    Then click random item link
    Then check that page with header equal to the title you clicked is displayed
    Then click “Home” link at the top navigation menu
    Then click “Institutions” icon under Resources sub-header
    Then check "https://edservices.wiley.com/" is opened in new window








