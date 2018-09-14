Feature: Title of your feature
  I want to use this template for my feature file

  @TC_1
  Scenario: Title of your scenario
    Given I perform GET request for URI "https://jsonplaceholder.typicode.com/todos/1"
		Then I should see response contains parameter 'title' with value 'delectus aut autem'

  @TC_2
  Scenario: Verify title
    Given I perform GET request for URI "https://jsonplaceholder.typicode.com/posts"
		Then I should see response contains parameter 'title' with value 'qui est esse' from list with primary key is 'userId' with '1'