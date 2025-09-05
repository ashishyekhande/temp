Feature: To check login frucntionality

Scenario Outline: To Check loginwith diffrent user
Given user is on login page
When user enters <user> and <pass>
And click on login button
Then "Successfully login" dashboard page shold disply

Examples:
    | user 							| pass 			| 
    |    standard_user 				|  secret_sauce |
    |   locked_out_user 			|  secret_sauce |
    |   problem_user 				|  secret_sauce |
    |  performance_glitch_user 		|  secret_sauce |
    |  error_user					|  secret_sauce |