
  package cucumberframework.steps;
  
  import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before; import io.cucumber.java.en.Given; import
  io.cucumber.java.en.Then; import io.cucumber.java.en.When;
  
  public class LoginSteps {
  
  WebDriver driver;
  
  @Before public void setup() throws IOException {
  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +
  "/chromedriver" );
  this.driver = new ChromeDriver();
  this.driver.manage().window().maximize();
  this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
  }
  
  @Given("User navigates to the {string} website")
  public void user_navigates_to_the_website(String url) {
     driver.get(url);
  }

  @Given("User clicks on  Login portal")
  public void user_clicks_on_login_portal() {
	  driver.findElement(By.id("login-portal")).click();
      
  }

  @Given("User enters valid username {string}")
  public void user_enters_valid_username(String username) {
	  String winHandlerBefore = driver.getWindowHandle();
	  for (String winHandler : driver.getWindowHandles()) {
		  driver.switchTo().window(winHandler);
	  }
	  driver.findElement(By.id("text")).sendKeys(username);
  }
      
  
  @Given("User enters valid password {string}")
  public void user_enters_valid_password(String password) {
	  
	  driver.findElement(By.id("password")).sendKeys(password);
      
  }

  @When("User clicks on the Login button")
  public void user_clicks_on_the_login_button() {
	  driver.findElement(By.id("login-button")).click();
	     
  }

  @Then("An alert is display to the user with {string}")
  public void an_alert_is_display_to_the_user_with(String message) throws Throwable {
	  try { 
	  } catch(Exception e) {
		  if(e.toString().contains("org.openqa.selenium.UnhandledAlertException")) {
			  Alert a = driver.switchTo().alert();
			  a.accept();         // clicks on OK
			  
			  assertEquals(a.getText(),message);
			  
	  }   
  }

	  driver.close();
  }

  
  }
 