package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class LabCorpSteps {

    public WebDriver driver;

    @Given("I am on the LabCorp website")
    public void iAmOnTheLabCorpWebsite() {
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
        Assert.assertEquals(actualJobTitle, expectedJobTitle);
    }

    @Then("I confirm job location")
    public void iConfirmJobLocation() {
        WebElement jobLocationElement = driver.findElement(By.xpath("//span[@class='au-target job-location']"));
        String actualJobLocation = jobLocationElement.getText().trim();
        String expectedJobLocation = "Buffalo, New York, United States of America";
        System.out.println(expectedJobLocation);
        System.out.println(actualJobLocation);
        Assert.assertTrue(actualJobLocation.contains(expectedJobLocation));
    }

    @Then("I confirm job ID")
    public void iConfirmJobID() {
        WebElement jobIDElement = driver.findElement(By.xpath("//span[@class='au-target jobId']"));
        String actualJobID = jobIDElement.getText();
        String expectedJobID = "246982";
        Assert.assertTrue(actualJobID.contains(expectedJobID));
    }

    @Then("I confirm job details")
    public void iConfirmJobDetails() {
        WebElement descriptionElement = driver.findElement(By.xpath("//div[@class='jd-info au-target']//p[1]"));
        WebElement requirementsElement = driver.findElement(By.xpath("//div[@class='jd-info au-target']//ul//li[1]//li[1]"));
        String expectedDescription = "OmniSeq by Labcorp is seeking a Quality Analyst to join our team in Buffalo, NY! The right candidate must have experience in either in a NYS permitted clinical laboratory, or a biopharma / research-based laboratory.";
        Assert.assertTrue(descriptionElement.getText().trim().contains(expectedDescription), "Job description does not match");
        String expectedRequirements = "Must have experience in a NYS permitted clinical laboratory or a biopharma/ research-based laboratory.";
        Assert.assertTrue(requirementsElement.getText().trim().contains(expectedRequirements), "Requirements do not match");
    }

    @And("I click on apply now button")
    public void iClickOnApplyNowButton() {
        WebElement applyNow = driver.findElement(By.linkText("Apply Now"));
        applyNow.click();
    }
}
