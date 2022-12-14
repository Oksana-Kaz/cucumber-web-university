Feature: Login to the WebDriverUniversity website
 I want to use this template validate the credentials of an existing user.

 Scenario Outline: Login to the WebDriverUniversity website with valid credentials
  Given User navigates to the "<url>" website
  And User clicks on  Login portal
  And User enters valid username "<username>"
  And User enters valid password "<password>"
  When User clicks on the Login button
  Then An alert is display to the user with "<message>"
  
   Examples: 
      | url                               | username  | password     | message              |  
      | http://www.webdriveruniversity.com| webdriver1 | webdriver1231 | validation failed |
     
  