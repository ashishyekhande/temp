Feature: Greenkart checkout 

Scenario: Checkout journy greenkart
Given i am on greenkart site
When items added in kart
And checkout is done
Then success messgae should be displayed
