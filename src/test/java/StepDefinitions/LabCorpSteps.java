package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LabCorpSteps {
	
	 public WebDriver driver;
   
    @Given("I am on the LabCorp website")
    public void iAmOnTheLabCorpWebsite() {
        //   System.seleniumProperty("webdriver.chrome.driver", "/Yochitha Personal/TestAutomationProject/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.labcorp.com/");
        driver.manage().window().maximize();
    }

    @When("I navigate to the Careers page")
    public void iNavigateToTheCareersPage() {
        WebElement careersLink = driver.findElement(By.linkText("Careers"));
        careersLink.click();
    }

   @And("I search for {string}")
   public void iSearchFor(String position) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys(position);
        WebElement searchButton = driver.findElement(By.xpath("//*[@type='submit']"));
        searchButton.click();
    }

    @And("I select a job listing")
     public void iSelectAJobListing() {
        driver.findElement(By.xpath("//div[@class='job-title']//span[contains(text(),'Quality Analyst')]")).click();
    }
    @Then("I confirm job title")
    public void iConfirmJobTitle() {

        WebElement jobTitleElement = driver.findElement(By.xpath("//h1[contains(text(),'Quality Analyst')]"));

        String actualJobTitle = jobTitleElement.getText();

        String expectedJobTitle = "Quality Analyst";
        Assert.assertEquals(actualJobTitle, expectedJobTitle, "Job title is not as expected");
    }
    
    @Then("I confirm job location")
    public void iConfirmJobLocation() {

        WebElement jobLocationElement = driver.findElement(By.xpath("//span[@class='job-location']"));
        

        String actualJobLocation = jobLocationElement.getText();
        

        String expectedJobLocation = "Buffalo, New York, United States of America";
        

        Assert.assertEquals(actualJobLocation, expectedJobLocation, "Job location is not as expected");
    }

    @Then("I confirm job ID")
    public void iConfirmJobID() {

        WebElement jobIDElement = driver.findElement(By.xpath("//span[@class='job-id']"));
        String actualJobID = jobIDElement.getText();
        String expectedJobID = "246982";
        Assert.assertEquals(actualJobID, expectedJobID, "Job ID is not as expected");
    }
    
    @Then("I confirm job details")
    public void iConfirmJobDetails() {

        WebElement descriptionElement = driver.findElement(By.xpath("//div[@class='job-description']"));
        WebElement requirementsElement = driver.findElement(By.xpath("//div[@class='requirements']"));
        

        String expectedDescription = "OmniSeq by Labcorp is seeking a Quality Analyst to join our team in Buffalo, NY! The right candidate must have experience in either in a NYS permitted clinical laboratory, or a biopharma / research-based laboratory.";
        Assert.assertEquals(descriptionElement.getText().contains(expectedDescription), "Job description does not match");


        String expectedRequirements = "Must have experience in a NYS permitted clinical laboratory or a biopharma/ research-based laboratory.";
        Assert.assertEquals(requirementsElement.getText().contains(expectedRequirements), "Requirements do not match");
        

    }
}