package e2e.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed.text",
        glue = "stepDefinitions",
        plugin = {
                "pretty"
        }
)
public class FailedRunner {
}
