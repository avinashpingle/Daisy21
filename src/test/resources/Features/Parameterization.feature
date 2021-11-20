Feature: This feature describes the parameterization in Cucumber

Scenario: Passing numeric parameter to the Gherkin step
	Given I have 15 and 62
	When I add them
	Then print result
@Regression @Smoke
Scenario: Passing String parameter to the gherkin step
	Given I have two words like "India hello" and "China hi"
	Then print them in alphabetic order
@Smoke
Scenario: Passing float parameters to gherkin step
	Given I have two float numbers 3.14 and 5.34
	Then add both float numbers
	And Print float result
@Regression
Scenario: Passing list of parameters to the Gherkin step
	Given I have following number:
	|10|
	|11|
	|12|
	|13|
	|14|
	|15|
	Then print all numbers from list
@Regression
Scenario: Passing table of parameters to the gherkin step
	Given I have following table:
	|firstlist|11|12|13|14|15|16|
	|secondlist|18|19|20|21|22|23|
	Then print them in row column format

Scenario Outline:
	Given I have two numbers from <row-number>
	When I add them
	Then verify if result is prime
	
Examples:
	|row-number|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	