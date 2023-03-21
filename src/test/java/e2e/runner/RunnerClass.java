package e2e.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "e2e/stepDefinitions",
        tags = "@smoke1",
        dryRun = false,
        plugin = {
                "pretty", "html:target/cucumber.html","json:target/cucumber.json",
                "rerun:target/failed.text"
        }
)
public class RunnerClass {
}
