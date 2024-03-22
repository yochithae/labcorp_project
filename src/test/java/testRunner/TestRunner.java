package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/Feature"
,glue={"src/test/java/stepDefinitions"}
)

public class TestRunner {
}
