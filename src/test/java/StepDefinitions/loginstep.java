package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginstep {

    WebDriver driver = WebDriverManager.getDriver();



    @Given("the user is on the main page of the website and get the Title of the page")
    public void the_user_is_on_the_main_page_of_the_website_and_get_the_title_of_the_page() {
        System.out.println("the user is on the main page");
    }

    @Then("The user will click on Account")
    public void the_user_will_click_on_account() throws InterruptedException {
        Thread.sleep(3000);
        WebElement account = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
        account.click();
        Thread.sleep(3000);
    }

    @When("The user will write invalid username {string} and password {string}")
    public void enterInvalidCredentials(String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
        passwordField.sendKeys(password);
        Thread.sleep(3000);
    }


    @Then("The user will click sign button")
    public void the_user_will_click_sign_button() throws InterruptedException {
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));
        signInButton.click();
        Thread.sleep(7000);
    }

    @When("the browser is gonna close")
    public void the_browser_is_gonna_close() {
        driver.quit();
    }
}
